;ControlFocus("title","text",controlID) Edit1=Edit instance 1
ControlFocus("文件上传", "","Edit1")


; Wait 10 seconds for the Upload window to appear
WinWait("[CLASS:#32770]","",10)


; Set the File name text on the Edit field

ControlSetText("文件上传", "", "Edit1", "D:\King\Eclipse\JMoney.Xiyuyou.Test\TestData\Png\退款照片.png")

Sleep(1000)

; Click on the Open button

ControlClick("文件上传", "","Button1");