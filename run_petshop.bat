@echo off
echo Compilando o Sistema Pet Shop...
javac -d . -cp . src\main\java\launcher\PetShopLauncher.java src\main\java\ui\swing\SistemaPetShopUI.java src\main\java\model\*.java
if %ERRORLEVEL% NEQ 0 (
    echo Erro na compilacao!
    pause
    exit /b 1
)

echo Iniciando o Sistema Pet Shop...
java launcher.PetShopLauncher
pause
