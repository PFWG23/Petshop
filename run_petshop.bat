@echo off
echo Compilando o Sistema Pet Shop...

REM Primeiro compilar os modelos
javac -d . src/main/java/model/*.java
if %ERRORLEVEL% NEQ 0 (
    echo Erro compilando modelos!
    pause
    exit /b 1
)

REM Depois compilar a interface
javac -d . -cp . src/main/java/ui/swing/*.java
if %ERRORLEVEL% NEQ 0 (
    echo Erro compilando interface!
    pause
    exit /b 1
)

REM Por ultimo compilar o launcher
javac -d . -cp . src/main/java/launcher/PetShopLauncher.java
if %ERRORLEVEL% NEQ 0 (
    echo Erro compilando launcher!
    pause
    exit /b 1
)

echo Iniciando o Sistema Pet Shop...
java launcher.PetShopLauncher
pause
