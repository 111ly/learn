How to set up C++ in Visual Studio Code:
step1:go https://code.visualstudio.com/docs/cpp/config-mingw   下载msys2,并在msys2运行pacman -S --needed base-devel mingw-w64-ucrt-x86_64-toolchain
step2:在用户的环境变量增加到bin
step3:在vs code 扩展C/C++ Extension Pack
step4：创建一个新的文件，选择语言c++,运行选择D:\msys64\ucrt64\bin\g++.exe
注意：代码路径一定不要带中文！！！
注意：代码路径一定不要带中文！！！
注意：代码路径一定不要带中文！！！
问题：
在编译时遇到问题：Fatal error: can't create C:\Users\³��\AppData\Local\Temp\ccCFw9uC.o: No such file or directory：
将temp  和 tmp 改为其它英文路径  只更改用户变量！！！
