# keloV0.4
date: 2024.01.09
author:  陈、王、何
disc:  用于物联网现场网关，连接kelo称量控制板和隔离控制器，采用串口通信，遵循MODBUS协议，功能包括人机界面、端口配置、称重校准、 数据库查询员工信息和气瓶信息  等

        JDK:17
        通信协议：kelo称量控制板MODBUS通讯协议_v0.2
        称量控制板硬件版本：v0.1 /  v0.1a
        称量控制板固件版本：v0.4  /  v0.4a
        数据库：MySQL
        
 	关于人脸识别
	      使用百度智能云解决方案，应用者需提前注册，按技术文档要求，创建应用后，将获取的APP ID、API Key、Secret Key粘贴复制至face文件下getAuth.java文件中。百度智能云中的应用中，点击创建人脸库，本代码请求参数中，用户组名为group1，用户id分别为001、002.......与SQL数据库的operateId一一对应。

	关于语音识别
	       使用百度智能云解决方案，应用者需提前注册，按技术文档要求，创建应用后，将获取的APP ID、API Key、Secret Key粘贴复制至speech文件下getAuth.java文件中。

	项目运行：mainApp.java
	开启虚拟串口，右键虚拟开发板，设置串口号与波特率。GUI界面点击工具栏的第二项，配置串口，设置与虚拟开发板连接的串口号与波特率，点击工具栏的第一项打开串口即可。


If you have any question, please contact email: muqi9100@gmail.com
