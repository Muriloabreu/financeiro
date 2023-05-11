# Financeiro

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Muriloabreu/financeiro/blob/main/LICENSE) 

# Sobre o projeto


Financeiro é uma API REST.

API - Java utilizando Spring boot com o proposito de realizar Vários CRUDs para controle de despesas semanais.
Nessa API podemos cadastrar e controlar despesas diária Expense(Despesa), direcionando a despesa para uma Branch(Filial), para um Emphoyee(Funcionário), adicionamos uma lista de ExpenseType(Tipo de despesa) e informamos o Box Opening(Caixa aberto) que contem valor em dinheiro, toda Expense(Despesa) devera abater o seu valor no Box Opening(Caixa aberto) e se o Box Opening(Caixa aberto) não tiver saldo a Expense(Despesa) não será cadastrada. Outro detalhe dessa API é que toda Expense(Despesa) é entregue o dinheiro em mãos ao Emphoyee(Funcionário), mas se o valor entregue for maior que a da Expense(Despesa), a diferênça devera ser devolvida e o campo valueReturn deverá informar a quantia a ser devolvida.

Os CRUDs são:
- Company; 
- Branch; 
- Emphoyee;
- Expense Type; 
- Expense;
- Box Opening


# Tecnologias utilizadas
## Back end
- Java
- Maven
- Spring Boot


## Implantação em produção

- Banco de dados: Postgres 9.5

## Back end
- Pré-requisitos: Java 17

# Como executar o projeto

Necessário ter um servidor Tomcat para poder rodar o projeto Java

##  Utilize uma plataforma de consultas de API's e faça a requisição de acordo os modelos disponíveis na sessão abaixo.
</code></pre>
 - Modelos de requisição JSON
</p>

</P>
<h5>Company</h5>

```json
{
        "id": 1,
        "corporate_name": "Company 02 SA",
        "fantasy_name": "Padaria Massa Quente",
        "cnpj": "002.002.00001-02"
    },
    {
        "id": 2,
        "corporate_name": "Company 03 LMTD",
        "fantasy_name": "FARMÁCIA SEM DOR",
        "cnpj": "002.002.00001-02"
    }
```
</p>
<h5>Branch</h5>

```json
{       
       "id": 2,
       "name": "FILIAL 02",
       "cnpj": "002.002.00001-02",
       "company": {
                    "id": 2,
                    "corporate_name": "Company 03 LMTD",
                    "fantasy_name": "FARMÁCIA SEM DOR",
                    "cnpj": "002.002.00001-02"
                  }
    }
```
</p>
<h5>Emphoyee</h5>

```json
{       
        "id": 1,
        "first_name": "Mario",
        "last_name": "José ",
        "cpf": "000.000.000-01",
        "branch": {
             "name": "FILIAL 02",
             "cnpj": "002.002.00001-02",
             "company": {
                    "id": 2,
                    "corporate_name": "Company 03 LMTD",
                    "fantasy_name": "FARMÁCIA SEM DOR",
                    "cnpj": "002.002.00001-02"
                  }

                }
        
        
 }
```
</p>
</p>

<h5>Box Opening</h5>

```json
{
        "id":1,
        "date_first": "2023-05-09T22:00:00Z",
        "valueOpening": 1000.00,
        "emphoyee": {
                     "id": 1,
        "first_name": "Mario",
        "last_name": "José ",
        "cpf": "000.000.000-01",
        "branch": {
             "name": "FILIAL 02",
             "cnpj": "002.002.00001-02",
             "company": {
                    "id": 2,
                    "corporate_name": "Company 03 LMTD",
                    "fantasy_name": "FARMÁCIA SEM DOR",
                    "cnpj": "002.002.00001-02"
                  }

                }
        },
        "department": "Financeiro"
           
    }
```
</p>
</p>

<h5>Expense Type</h5>

```json
{
    "id": 1,
    "name": "CAFÉ MANHÃ TERCEIRO",
    "value": 18.00
    
    
    
}
```
</p>
</p>
<h5>Expense </h5>

```json
{
    "branche": {
                 "id": 2,
                 "name": "FILIAL 02",
                 "cnpj": "002.002.00001-02",
                 "company": {
                            "id": 2,
                            "corporate_name": "Company 03 LMTD",
                            "fantasy_name": "FARMÁCIA SEM DOR",
                            "cnpj": "002.002.00001-02"
                              }
    
    },
    "emphoyee": {
                "id": 1,
                "first_name": "Mario",
                "last_name": "José ",
                "cpf": "000.000.000-01",
                "branch": {
                             "name": "FILIAL 02",
                             "cnpj": "002.002.00001-02",
                             "company": {
                                          "id": 2,
                                          "corporate_name": "Company 03 LMTD",
                                          "fantasy_name": "FARMÁCIA SEM DOR",
                                          "cnpj": "002.002.00001-02"
                                         }
                           },
                "department": "Financeiro."
    },
    "expensesTypes":[

                {
                    "id": 1,
                    "name": "CAFÉ MANHÃ TERCEIRO",
                    "value": 18.0
                 }
                 {
                    "id": 2,
                    "name": "CAFÉ MANHÃ CASA",
                    "value": 22.0
                 }
                

    ],
    "boxOpening":{
                    "id":1,
                    "date_first": "2023-05-09T22:00:00Z",
                    "valueOpening": 1000.00,
                    "emphoyee": {
                                 "id": 1,
                                "first_name": "Mario",
                                "last_name": "José ",
                                "cpf": "000.000.000-01",
                                "branch": {
                                           "name": "FILIAL 02",
                                           "cnpj": "002.002.00001-02",
                                "company": {
                                            "id": 2,
                                            "corporate_name": "Company 03 LMTD",
                                            "fantasy_name": "FARMÁCIA SEM DOR",
                                            "cnpj": "002.002.00001-02"
                                            }

                                            }
        },
                     "department": "Financeiro"
                    },
                    "valueDelivered": 100.0

                }
    
    
    
}
```
</p>
</p>

- Baixar o projeto

```bash
# clonar repositório
git clone git@github.com:Muriloabreu/financeiro.git

```

# Autor

Murilo Abreu do Nascimento

https://www.linkedin.com/in/murilo-abreu/
