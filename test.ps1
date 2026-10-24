$imgs = Get-ChildItem -Path ./materials/

foreach ($img in $imgs) {
    Write-Host "正在测试$($img.Name)..." -ForegroundColor Green
    & 'C:\Program Files\Javas\JDK25\bin\java.exe' .\src\cn\yuang2714\chmlfrpimgdetector\Detector.java $img.FullName
    Write-Host
}
Write-Host "测试完成" -ForegroundColor Green