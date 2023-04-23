# TSMMeta

## Motivação
Projeto feito com base em um problema no qual uma empresa em específico estava tendo com a parametrização das metas mensais.

## Objetivo
Juntar todos os gastos (fixos e variáveis) e adicionar os tipos de impostos imbutidos (impostos diretos na fonte + impostos após os primeiros)

## API
Loja
Imposto
Gastos
Meta
Colaboradores

Cada um com pelo menos 3 pré cadastrados no banco de dados

## Recomendações para executar a API
(*Deploy* será realizado futuramente)  
Será necessário clonar o pacote e executar através de uma IDE (utilizei o Intellij)  
Ao clonar vá até o arquivo TSMMetaApplication e execute (Run)  
Caso utilize o Postman aqui está um link direto da Collection de requisições -> [Postman Collection](https://api.postman.com/collections/9357552-160a0c51-c662-4b41-9e7e-fb4dd9a30046?access_key=)

## Trabalhos futuros
Finalizar estrutura da base do cálculo da Meta  
Criar ambiente de dev com Postegres SQL (está utilizando o H2, um banco de dados em memória no ambiente de test)  
Deploy no railway  

## Base do cálculo
-> x = (y * z) / 100 - z  
g = montante de gastos (gastos fixos (luz, aluguel, salário de funcionários...) + gastos variáveis (consertos, troca de objetos...))  
f = imposto que é aplicado diretamente na fonte (100% em cima do faturamento)  
a = imposto após amortização  
t = total  

t = gastos + ((gastos * f)/ 100 - f)  
t = total + ((total * a) / 100 - a)  
