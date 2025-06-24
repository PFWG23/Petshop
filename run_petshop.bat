@echo off
cd /d "%~dp0"

echo    PetShop Manager - Sistema de Gestao

echo [1/3] Verificando estrutura de diretorios...
if not exist "build" mkdir build
if not exist "data" mkdir data

echo [2/3] Compilando codigo fonte...
javac -d build -cp src\main\java src\main\java\util\*.java src\main\java\ui\swing\*.java

if %errorlevel% neq 0 (
    echo.
    echo ERRO: Falha na compilacao!
    echo Verifique se o Java esta instalado corretamente.
    echo.
    pause
    exit /b 1
)

echo [3/3] Iniciando PetShop Manager...
echo.
java -cp build ui.swing.SistemaPetShopUI

if %errorlevel% neq 0 (
    echo.
    echo ERRO: Falha na execucao!
    echo Verifique se o Java Runtime esta instalado.
    echo.
)

echo.
echo Sistema finalizado. Pressione qualquer tecla para sair.
pause > nul
