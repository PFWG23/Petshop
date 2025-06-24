@echo off
cd /d "c:\Users\patri\Desktop\Petshop"

echo Compilando PetShop Manager...
javac -d build -cp src\main\java src\main\java\util\*.java src\main\java\ui\swing\*.java

if %errorlevel% neq 0 (
    echo Erro na compilacao!
    pause
    exit /b 1
)

echo Executando PetShop Manager...
java -cp build ui.swing.SistemaPetShopUI

pause
