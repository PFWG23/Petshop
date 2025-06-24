# Sistema de Gerenciamento Pet Shop

## Sobre o Projeto

Sistema completo para gerenciamento de pet shop desenvolvido em Java com interface Swing. O projeto foi criado aplicando conceitos de Programação Orientada a Objetos e arquitetura modular para facilitar manutenção e expansão.

## Funcionalidades do Sistema

O sistema oferece controle completo para operações de pet shop:

- Gerenciamento de clientes com dados de contato
- Cadastro de pets vinculados aos respectivos donos
- Registro de vendas de servicos prestados
- Sistema de agendamentos para servicos futuros
- Geração de relatorios com dados estatisticos

## Interface do Usuario

### Tela Principal
A aplicação apresenta layout dividido em quatro areas principais:

- Cabecalho com titulo do sistema e horario atual
- Menu lateral com navegacao entre funcionalidades
- Area central com quatro tabelas de dados organizadas em grid 2x2
- Barra de status na parte inferior

### Tabelas de Dados
- Superior esquerda: Lista de pets cadastrados
- Superior direita: Base de clientes ativos
- Inferior esquerda: Historico de vendas realizadas
- Inferior direita: Proximos agendamentos

## Modulos do Sistema

### Cadastro de Clientes
Armazena informacoes completas dos proprietarios:
- ID automatico sequencial
- Nome completo
- Telefone para contato
- Email para comunicacao

### Cadastro de Pets
Registra dados dos animais atendidos:
- ID automatico vinculado ao sistema
- Nome do animal
- Tipo (Cao, Gato, Ave, Coelho, Outros)
- Raca especifica
- Idade do animal

### Controle de Vendas
Gerencia servicos prestados com valores:
- Banho Completo
- Tosa Higienica
- Consulta Veterinaria
- Vacinacao
- Vermifugacao
- Cirurgia
- Hospedagem

### Sistema de Agendamentos
Organiza servicos futuros por:
- Data do agendamento
- Horario especifico
- Cliente responsavel
- Pet a ser atendido
- Tipo de servico solicitado

## Estrutura do Codigo

O projeto segue arquitetura modular organizada em pacotes:

```
src/main/java/
├── launcher/
│   └── PetShopApp.java           # Ponto de entrada da aplicacao
├── ui/main/
│   └── MainWindow.java           # Janela principal do sistema
├── ui/panels/
│   ├── HeaderPanel.java          # Componente do cabecalho
│   ├── SidebarPanel.java         # Menu lateral de navegacao
│   └── TablePanel.java           # Gerenciamento das tabelas
├── ui/dialogs/
│   ├── PetDialog.java            # Dialog para cadastro de pets
│   ├── ClientDialog.java         # Dialog para cadastro de clientes
│   ├── SaleDialog.java           # Dialog para registro de vendas
│   └── ScheduleDialog.java       # Dialog para agendamentos
└── ui/components/
    ├── ButtonUtils.java          # Utilitarios para botoes
    └── ReportGenerator.java      # Gerador de relatorios
```

## Como Executar o Sistema

### Passo 1: Verificar Prerequisitos
Certifique-se de ter o Java instalado no sistema:
```bash
java -version
```

### Passo 2: Executar via Script (Recomendado)
Na pasta do projeto, execute o arquivo batch:
```bash
run_petshop.bat
```

### Passo 3: Execucao Manual (Alternativa)
Se preferir compilar manualmente:

```bash
# Navegar para o diretorio do projeto
cd c:\Users\patri\Desktop\Petshop

# Compilar todos os arquivos
javac -d build -cp src\main\java src\main\java\launcher\*.java src\main\java\ui\main\*.java src\main\java\ui\panels\*.java src\main\java\ui\dialogs\*.java src\main\java\ui\components\*.java

# Executar a aplicacao
java -cp build launcher.PetShopApp
```

### Passo 4: Verificar Funcionamento
Apos a execucao, deve abrir a janela principal com:
- Interface grafica carregada
- Dados de exemplo preenchidos nas tabelas
- Menu lateral funcional
- Botoes de cadastro ativos

## Validacoes e Regras de Negocio

O sistema implementa diversas validacoes para garantir integridade dos dados:

### Dependencias entre Modulos
- Nao e possivel cadastrar pets sem ter pelo menos um cliente
- Vendas e agendamentos requerem clientes previamente cadastrados
- IDs sao gerados automaticamente pelo sistema

### Validacao de Formularios
- Todos os campos obrigatorios devem ser preenchidos
- Valores numericos sao validados antes do salvamento
- Datas e horarios seguem formatos especificos

### Controle de Dados
- Sistema previne duplicacao acidental de registros
- Campos de texto tem validacao de tamanho minimo
- Comboboxes restringem opcoes a valores validos

## Dados Pre-carregados

Para facilitar teste e demonstracao, o sistema inicia com dados exemplo:

### Base de Pets
- Bartolomeu (Cao, SRD, 4 anos)
- Fifi (Gato, Persa, 2 anos)
- Thor (Cao, Rottweiler, 6 anos)
- Luna (Gato, Siames, 1 ano)
- Pipoca (Cao, Vira-lata, 7 anos)
- Mel (Gato, Munchkin, 3 anos)

### Clientes Cadastrados
- Roberta Machado - (11) 97654-3210 - roberta.m@email.com
- Carlos Eduardo Santos - (11) 98765-4321 - carlosE@hotmail.com
- Fernanda M. Santos - (11) 99876-5432 - fe.santos@outlook.com
- Ricardo Silva Jr. - (11) 91234-5678 - ricardo.s@yahoo.com
- Ana Beatriz Oliveira - (11) 94567-8901 - ana.bia@gmail.com
- Marcos Antonio - (11) 93456-7890 - marcosant@uol.com.br

### Vendas Registradas
- Roberta Machado - Banho Completo - R$ 85,00
- Carlos Eduardo Santos - Consulta + Vacina - R$ 120,00
- Fernanda M. Santos - Tosa Higienica - R$ 60,00
- Ana Beatriz Oliveira - Vermifugacao - R$ 35,00

### Agendamentos Futuros
- 24/06/2025 08:30 - Roberta Machado (Bartolomeu) - Check-up
- 24/06/2025 15:00 - Carlos Eduardo Santos (Fifi) - Vacinacao
- 25/06/2025 09:15 - Fernanda M. Santos (Luna) - Consulta
- 26/06/2025 14:30 - Ana Beatriz Oliveira (Pipoca) - Banho
- 27/06/2025 10:00 - Marcos Antonio (Thor) - Tosa

## Decisoes de Implementacao

### Tecnologias Utilizadas
- Java Swing para interface grafica desktop
- BorderLayout como estrutura principal da tela
- GridLayout para organizacao das tabelas em grid 2x2
- BoxLayout para menu lateral vertical
- FlowLayout para elementos horizontais

### Padrao de Arquitetura
- Separacao clara entre componentes visuais
- Dialogs independentes para cada funcionalidade
- Utilitarios reutilizaveis em pacote separado
- Codigo organizado por responsabilidade

### Escolhas de Design
- Interface familiar ao usuario Windows
- Cores sobrias e profissionais
- Fontes padrao do sistema (Segoe UI)
- Layouts responsivos que se adaptam ao redimensionamento

## Limitacoes Conhecidas

### Persistencia de Dados
- Dados armazenados apenas em memoria durante execucao
- Informacoes nao sao salvas apos fechar o programa
- Para ambiente produtivo seria necessario implementar banco de dados

### Funcionalidades Futuras
- Sistema de backup automatico
- Relatorios mais detalhados com graficos
- Integracao com sistema de pagamento
- Notificacoes de agendamento por email

### Melhorias de Interface
- Temas personalizaveis
- Atalhos de teclado
- Sistema de busca e filtros
- Impressao de relatorios

## Conceitos Aplicados

### Programacao Orientada a Objetos
- Encapsulamento atraves de modificadores de acesso
- Composicao entre classes de interface e dados
- Separacao de responsabilidades por classe
- Reutilizacao de codigo com heranca de componentes Swing

### Padroes de Design
- Strategy pattern para diferentes tipos de dialogs
- Factory pattern para criacao de botoes
- Observer pattern para eventos de interface
- MVC pattern na separacao de dados e apresentacao

## Solucao de Problemas

### Erro de Compilacao
```bash
# Verificar se esta na pasta correta
cd c:\Users\patri\Desktop\Petshop

# Limpar arquivos compilados anteriores
rmdir /s build
mkdir build

# Tentar novamente
run_petshop.bat
```

### Aplicacao nao Abre
1. Verificar se Java esta instalado e no PATH
2. Executar java -version para confirmar versao
3. Verificar se todos os arquivos foram compilados corretamente
4. Tentar execucao manual passo a passo

### Interface com Problemas
- Verificar resolucao da tela (minimo 1024x768 recomendado)
- Confirmar se nao ha outras aplicacoes Java rodando
- Reiniciar o sistema se necessario

## Informacoes Tecnicas

- Linguagem: Java 8 ou superior
- Framework GUI: Swing
- Arquitetura: Modular com separacao por pacotes
- Tamanho: Aproximadamente 1500 linhas de codigo
- Compatibilidade: Windows, Linux, macOS

---

Sistema Pet Shop Manager
Versao 2.4 - Junho 2025