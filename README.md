# Petshop 

Sistema para Pet Shop
1. Visão Geral
O sistema tem como objetivo gerenciar o cadastro de clientes e seus pets em um
pet shop. Ele deve permitir a gestão de clientes e seus respectivos animais de
estimação, bem como a contratação de serviços avulsos ou pacotes de serviços.
O sistema também deve possibilitar a relação entre clientes, pets e serviços
contratados.
2. Requisitos do Sistema
2.1. Funcionalidades Principais
• Cadastro de Clientes
o Clientes possuem informações como nome, telefone e e-mail.
o Deve ser possível listar, buscar e excluir clientes cadastrados.
• Cadastro de Pets
o Cada cliente pode ter um ou mais pets associados.
o Pets possuem informações como nome, espécie, raça, idade e
peso.
o Deve ser possível listar, buscar e excluir pets cadastrados.
• Contratação de Serviços
o Os clientes podem contratar serviços avulsos ou pacotes de
serviços.
o Exemplos de serviços incluem:
▪ Banho e tosa
▪ Consulta veterinária
▪ Hospedagem
▪ Adestramento
o Deve ser possível listar, buscar e cancelar serviços contratados.
2.2. Regras de Negócio
• Um cliente só pode contratar serviços para seus próprios pets cadastrados.
• Deve ser possível agendar serviços para datas futuras.
• Pacotes de serviços podem incluir descontos em relação aos serviços
avulsos.
3. Estrutura do Sistema
3.1. Classes Principais
Classe Cliente
public class Cliente {
}
Classe Pet
public class Pet {
}
Classe Servico
public abstract class Servico {
}
Exemplos de Serviços
public class BanhoETosa extends Servico {
}
Classe PacoteServicos
public class PacoteServicos {
}
4. Tecnologias Utilizadas
• Linguagem: Java 11+
5. Critérios de Avaliação
• Organização do código e utilização de conceitos de programação orientado
a objeto;
• Manual de utilização do sistema;
• Funcionamento do sistema conforme descrito nas instruções;
5. Considerações Finais
Este projeto visa criar um sistema flexível e escalável para o gerenciamento de
agências de viagens, permitindo futuras melhorias.
