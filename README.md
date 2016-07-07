# Listviewhidden
to get a Git into your project
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.yingbindegithub:Listviewhidden:-SNAPSHOT'
	}
