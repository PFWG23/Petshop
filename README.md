# Pet Shop Management System 🐾

## Sobre o Projeto

Este é o projeto final da disciplina de **Programação 2**, desenvolvido pelos estudantes **João Möller**, **Patrick Gomes** e **Renato Amaral**. 

O objetivo era criar um sistema completo para gerenciamento de Pet Shop usando Java Swing para a interface gráfica, aplicando todos os conceitos de Programação Orientada a Objetos que aprendemos durante o curso.

## O que o Sistema Faz

O sistema permite gerenciar todas as operações de um pet shop:

- **Cadastro de Clientes** - Guardar dados dos donos dos pets
- **Cadastro de Pets** - Registrar os animais e vincular aos donos
- **Controle de Vendas** - Registrar serviços vendidos
- **Sistema de Agendamentos** - Agendar serviços futuros
- **Relatórios** - Ver estatísticas do sistema

##  Como Funciona a Interface

### Tela Principal
Quando você abre o sistema, aparece uma tela principal dividida em:

- **Cabeçalho azul** com o título e data/hora atual
- **Menu lateral** com 6 botões (Início, Pets, Clientes, Vendas, Agendamentos, Relatórios)
- **4 tabelas no centro** mostrando os dados em formato 2x2:
  - Pets Cadastrados (canto superior esquerdo)
  - Clientes Cadastrados (canto superior direito)
  - Vendas Realizadas (canto inferior esquerdo)
  - Próximos Agendamentos (canto inferior direito)

### Cores e Visual
- **Azul principal:** `#4169E1` (Royal Blue) - usado no cabeçalho e botões
- **Azul claro:** `#87CEEB` (Sky Blue) - usado no menu lateral
- **Fundo:** `#F8F9FA` (cinza claro)
- **Painéis:** Branco para as tabelas

## Funcionalidades Detalhadas

### Gestão de Clientes
```
Campos: ID, Nome, Telefone, Email
Exemplo: 1, João Silva, (11) 99999-1111, joao@email.com
```

### Gestão de Pets
```
Campos: ID, Nome, Espécie, Raça, Idade
Espécies disponíveis: Cachorro, Gato, Pássaro, Peixe, Hamster
Exemplo: 1, Buddy, Cachorro, Golden Retriever, 3
```

### Sistema de Vendas
Serviços disponíveis com preços fixos:
- **Banho e Tosa** - R$ 50,00
- **Consulta Veterinária** - R$ 100,00
- **Hospedagem** - R$ 80,00
- **Adestramento** - R$ 120,00

### Agendamentos
- Horários: das 8h00 às 18h30 (de 30 em 30 minutos)
- Vincula cliente + pet + serviço + data/hora

## Estrutura do Código

```
src/main/java/
├── ui/swing/
│   └── SistemaPetShopUI.java      # Interface principal (792 linhas)
├── launcher/
│   └── PetShopLauncher.java       # Tela de inicialização
├── ui/console/
│   └── SistemaPetShop.java        # Versão original em console
└── model/
    ├── Cliente.java               # Classe do cliente
    ├── Pet.java                   # Classe do pet
    ├── Servico.java              # Classe abstrata para serviços
    ├── BanhoETosa.java           # Implementação do serviço
    ├── ConsultaVeterinaria.java  # Implementação do serviço
    ├── Hospedagem.java           # Implementação do serviço
    └── Adestramento.java         # Implementação do serviço
```

## Como Executar

### Método 1: Usando o Script (Mais Fácil)
```bash
# Execute o arquivo batch
run_petshop.bat
```

### Método 2: Compilar Manualmente
```bash
# Vá para a pasta do projeto
cd c:\Users\patri\Desktop\Petshop

# Compile todos os arquivos
javac -d . src\main\java\ui\swing\SistemaPetShopUI.java

# Execute o sistema
java ui.swing.SistemaPetShopUI
```

### Método 3: Com o Launcher
```bash
# Compile o launcher primeiro
javac -d . src\main\java\launcher\PetShopLauncher.java src\main\java\ui\swing\SistemaPetShopUI.java

# Execute o launcher
java launcher.PetShopLauncher
```

## Validações Implementadas

O sistema tem várias validações para evitar erros:

1. **Dependência Cliente-Pet:** Não pode cadastrar pet sem ter cliente
2. **Campos obrigatórios:** Todos os campos precisam ser preenchidos
3. **IDs automáticos:** O sistema gera IDs automaticamente
4. **Validação de formulários:** Verifica se todos os dados foram inseridos

## Dados de Exemplo

O sistema já vem com alguns dados de exemplo para testar:

**Pets:**
- Buddy (Cachorro, Golden Retriever, 3 anos)
- Luna (Gato, Persa, 2 anos)
- Rocky (Cachorro, Bulldog, 5 anos)

**Clientes:**
- João Silva - (11) 99999-1111 - joao@email.com
- Maria Santos - (11) 99999-2222 - maria@email.com
- Pedro Costa - (11) 99999-3333 - pedro@email.com

**Vendas:**
- João Silva - Banho e Tosa - R$ 50,00
- Maria Santos - Consulta Veterinária - R$ 100,00
- Pedro Costa - Hospedagem - R$ 80,00

## Escolhas de Design

### Por que Swing?
- Era o requisito da disciplina
- Permite criar interfaces desktop completas
- Boa para aprender conceitos de GUI

### Layout Escolhido
- **BorderLayout** para a estrutura principal
- **GridLayout** para as tabelas (2x2)
- **BoxLayout** para o menu lateral
- **FlowLayout** para o rodapé

### Estilo de Código
- Comentários explicativos em português
- Variáveis com nomes claros
- Métodos divididos por funcionalidade
- Código legível para estudantes

## Limitações Conhecidas

1. **Persistência:** Os dados só ficam na memória, poderia ser incorporada uma cloud para armazenar(não salva em arquivo)
2. **Validações:** Poderiam ser mais robustas
3. **Interface:** Poderia ter mais recursos visuais
4. **Relatórios:** São bem simples, só mostram contadores

## Conceitos de POO Aplicados

- **Encapsulamento:** Classes com atributos privados
- **Herança:** Serviços herdam de classe abstrata
- **Polimorfismo:** Diferentes tipos de serviços
- **Abstração:** Interface clara entre camadas

## Equipe de Desenvolvimento

- **João Möller** - Desenvolvimento do sistema
- **Patrick Gomes** - Interface e funcionalidades
- **Renato Amaral** - Testes e validações

## Estatísticas do Projeto

- **Linguagem:** Java
- **Linhas de código:** ~800 linhas na interface principal
- **Arquivos:** 10+ arquivos Java
- **Tempo de desenvolvimento:** maior parte do semestre
- **Interface:** 100% Swing

## Suporte

Se tiver dúvidas sobre o código ou como executar:
1. Verifique se o Java está instalado
2. Confira se está na pasta correta
3. Tente compilar arquivo por arquivo se der erro

---
*Projeto Final - Programação 2 - 2025*
*Sistema Pet Shop - com Interface Swing*