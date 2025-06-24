@echo off
cd /d "c:\Users\patri\Desktop\Petshop"

echo Compilando projeto PetShop...
javac -d build -cp src\main\java src\main\java\launcher\*.java src\main\java\ui\main\*.java src\main\java\ui\panels\*.java src\main\java\ui\dialogs\*.java src\main\java\ui\components\*.java

if %errorlevel% neq 0 (
    echo Erro na compilacao!
    pause
    exit /b 1
)

echo Executando PetShop Manager...
java -cp build launcher.PetShopApp

pause
