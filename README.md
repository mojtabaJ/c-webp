# WebP Converter  [![Maven Central](https://img.shields.io/maven-central/v/io.github.mojtabaj/c-webp)](https://search.maven.org/search?q=g:io.github.mojtabaj%20AND%20a:c-webp) 
A simple compression utility for converting images (jpeg, png, tiff) to  **WebP** format.


 

## Installation

- First make sure to install `cwebp` on your machine, e.g. via [this link](https://developers.google.com/speed/webp/docs/precompiled)

### Maven dependency

```xml
<dependency>
  <groupId>io.github.mojtabaj</groupId>
  <artifactId>c-webp</artifactId>
  <version>1.0.2</version>
</dependency>
```



### Usage

```java
//Use WebpConverter for converting image to webp byte with 80 quality
byte[] webpByte = WebpConverter.imageByteToWebpByte(imageByteArray, 80);
byte[] webpByte = WebpConverter.imageFileToWebpByte("../inputImage.png", 80);

//Use WebpConverter for converting image to webp file with 80 quality
File webpFile = WebpConverter.imageByteToWebpFile(imageByteArray,"../outputImage.webp", 80);
File webpFile = WebpConverter.imageFileToWebpFile("../inputImage.png","../outputImage.webp", 80);


//Use CWebp to create and execute cwebp command to compress an image using the WebP format.
CWebp cwebp = new CWebp()
        .input(imageFilePath) // specify the input file.
        .quality(80) //factor for RGB channels
        .resize(512, 512) // resize the source to a rectangle with size width x height.
        .output(outputFilePath); // specify the output WebP file
cwebp.execute(); // executes the specified string command in a separate process.
```


## License

Copyright 2022 Mojtaba Jalambadani

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership. The ASF licenses this
file to you under the Apache License, Version 2.0 (the “License”); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed
under the License is distributed on an “AS IS” BASIS, WITHOUT WARRANTIES OR
CONDITIONS OF ANY KIND, either express or implied. See the License for the
specific language governing permissions and limitations under the License.