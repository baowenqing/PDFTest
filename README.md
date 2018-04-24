### PDF一些解决方案的demo


> 包含了两个框架，一个谷歌的api方式  一个webview的方式，对比如下：
>
 
- **PdfRenderer** ：谷歌的api，加载pdf转化为bitmap，利用iv进行呈现；
- **PDFView** ：[PDFView](https://github.com/JoanZapata/android-pdfview)2000多个星星，不过作者不在维护了。在demo里面导入源代码，修复了放大后模糊的问题。安装下来8M左右，内存80M-100M，CPU占用0-10%，感觉不错。
- **pdfviewer** ：[pdfviewer](https://github.com/barteksc/AndroidPdfViewer)3000多个星星,作者也一直维护，就是库有点太大了，19M，耗费资源比PDFView稍微低一些。
- **webview-js加载** ：利用webview配合pdf.js的方式进行加载，耗费资源较高。

> 感谢以上作者
