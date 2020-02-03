# Mutliple Line Charts Graph

Quick Start 📈
Add the library to your Android project, then check out the examples below!

Gradle Setup
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'
}
Maven Setup
<!-- <repositories> section of pom.xml -->
<repository>
    <id>jitpack.io</id>
   <url>https://jitpack.io</url>
</repository>

<!-- <dependencies> section of pom.xml -->
<dependency>
    <groupId>com.github.PhilJay</groupId>
    <artifactId>MPAndroidChart</artifactId>
    <version>v3.1.0</version>
</dependency>




Creating mulitple Line chart graph Using mp chart library.
1)  Added custom marker to display value of intersection point in graph(MyMarkerView.java).
2)  Added custom point drawable for xml.
3)  Created MyValueFormatter class to add unit of y axis ( like inch,cm,kg ) and etc.



![alt text](http://dvf5ko0ucq3fk.cloudfront.net/images/1580475355078multiplelinecharts.png)
