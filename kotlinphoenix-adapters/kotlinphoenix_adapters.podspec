Pod::Spec.new do |spec|
    spec.name                     = 'kotlinphoenix_adapters'
    spec.version                  = '1.0.4'
    spec.homepage                 = 'https://github.com/ajacquierbret/kotlin-phoenix/kotlinphoenix-adapters'
    spec.source                   = { :http=> ''}
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'Adapters for using Kotlin Phoenix with third-party GraphQL clients'
    spec.vendored_frameworks      = 'build/cocoapods/framework/kotlinphoenix_adapters.framework'
    spec.libraries                = 'c++'
    spec.ios.deployment_target = '14.1'
                
                
    if !Dir.exist?('build/cocoapods/framework/kotlinphoenix_adapters.framework') || Dir.empty?('build/cocoapods/framework/kotlinphoenix_adapters.framework')
        raise "

        Kotlin framework 'kotlinphoenix_adapters' doesn't exist yet, so a proper Xcode project can't be generated.
        'pod install' should be executed after running ':generateDummyFramework' Gradle task:

            ./gradlew :kotlinphoenix-adapters:generateDummyFramework

        Alternatively, proper pod installation is performed during Gradle sync in the IDE (if Podfile location is set)"
    end
                
    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':kotlinphoenix-adapters',
        'PRODUCT_MODULE_NAME' => 'kotlinphoenix_adapters',
    }
                
    spec.script_phases = [
        {
            :name => 'Build kotlinphoenix_adapters',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED" ]; then
                  echo "Skipping Gradle build task invocation due to OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/../gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration="$CONFIGURATION"
            SCRIPT
        }
    ]
                
end