
[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[Docker]:https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white
[sql]:https://img.shields.io/badge/Postgresql-%234169E1?style=for-the-badge&logo=postgresql&logoColor=white&color=%234169E1
[postman]:https://img.shields.io/badge/postman-%23FF6C37?style=for-the-badge&logo=postman&logoColor=white
[license]:https://img.shields.io/github/license/pedro-henrique1/estacionamento_api?style=for-the-badge



# API REST para Gerenciamento de Estacionamento

![][JAVA_BADGE]
![][SPRING_BADGE]
![][Docker]
![][sql]
![][postman]
![][license]

A API de Gerenciamento de Estacionamento é uma solução desenvolvida para facilitar o controle de estabelecimentos de
estacionamento de carros e motos. A API permite o cadastro de empresas e veículos, além de gerenciar a entrada e saída
dos veículos de forma organizada.

# Tecnologias

- Java
- Spring boot
- Postgres
- Docker

# Instalação

- Clone o repositório

```git
  git clone https://github.com/pedro-henrique1/estacionamento_api.git
  cd estacionamento_api
```

- Configure o application.properties

```
  cd src/main/resources
  
  cp example.application.properties  application.properties
```

- Iniciando o projeto:

```
 docker-compose up --build
 
```

# Endpoints

<h3>📌 Estabelecimentos</h3>
  <table>
    <thead>
      <tr>
        <th>Route</th>
        <th>Description</th>
        <th>Response Example</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><kbd>POST /establishments</kbd></td>
        <td>Cadastra um novo estabelecimento.</td>
        <td>
          <pre><code class="json">
{
  "id": 1,
  "name": "Estacionamento Central",
  "cnpj": "12.345.678/0001-99",
  "addressId": 1,
  "phone": "(31) 98765-4321",
  "motorcycleSpots": 10,
  "carSpots": 50
}
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>GET /establishments</kbd></td>
        <td>Retorna a lista de estabelecimentos.</td>
        <td>
          <pre><code class="json">
[
  {
    "id": 1,
    "name": "Estacionamento Central",
    "cnpj": "12.345.678/0001-99",
    "phone": "(31) 98765-4321"
  }
]
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>GET /establishments/{id}</kbd></td>
        <td>Retorna os detalhes de um estabelecimento.</td>
        <td>
          <pre><code class="json">
{
  "id": 1,
  "name": "Estacionamento Central",
  "cnpj": "12.345.678/0001-99",
  "addressId": 1,
  "phone": "(31) 98765-4321",
  "motorcycleSpots": 10,
  "carSpots": 50
}
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>PUT /establishments/{id}</kbd></td>
        <td>Atualiza os dados de um estabelecimento.</td>
        <td>
          <pre><code class="json">
{
  "message": "Estabelecimento atualizado com sucesso"
}
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>DELETE /establishments/{id}</kbd></td>
        <td>Remove um estabelecimento.</td>
        <td>
          <pre><code class="json">
{
  "message": "Estabelecimento removido com sucesso"
}
          </code></pre>
        </td>
      </tr>
    </tbody>
  </table>

<h3>🚗 Veículos</h3>
  <table>
    <thead>
      <tr>
        <th>Route</th>
        <th>Description</th>
        <th>Response Example</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><kbd>POST /vehicle</kbd></td>
        <td>Cadastra um novo veículo.</td>
        <td>
          <pre><code class="json">
{
  "id": 1,
  "brand": "Toyota",
  "model": "Corolla",
  "color": "Preto",
  "licensePlate": "ABC-1234",
  "type": "car"
}
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>GET /vehicle</kbd></td>
        <td>Retorna a lista de veículos.</td>
        <td>
          <pre><code class="json">
[
  {
    "id": 1,
    "brand": "Toyota",
    "model": "Corolla",
    "color": "Preto",
    "licensePlate": "ABC-1234",
    "type": "car"
  }
]
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>GET /vehicle/{id}</kbd></td>
        <td>Retorna os detalhes de um veículo.</td>
        <td>
          <pre><code class="json">
{
  "id": 1,
  "brand": "Toyota",
  "model": "Corolla",
  "color": "Preto",
  "licensePlate": "ABC-1234",
  "type": "car"
}
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>PUT/PATCH /vehicle</kbd></td>
        <td>Atualiza os dados de um veículo.</td>
        <td>
          <pre><code class="json">
{
  "message": "Veículo atualizado com sucesso"
}
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>DELETE /vehicle/{id}</kbd></td>
        <td>Remove um veículo.</td>
        <td>
          <pre><code class="json">
{
  "message": "Veículo removido com sucesso"
}
          </code></pre>
        </td>
      </tr>
    </tbody>
  </table>

<h3>🏠 Endereços</h3>
  <table>
    <thead>
      <tr>
        <th>Route</th>
        <th>Description</th>
        <th>Response Example</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><kbd>POST /address</kbd></td>
        <td>Cadastra um novo endereço.</td>
        <td>
          <pre><code class="json">
{
  "id": 1,
  "street": "Rua das Flores",
  "number": "123",
  "city": "Belo Horizonte",
  "state": "MG",
  "zipCode": "30100-000"
}
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>GET /address</kbd></td>
        <td>Retorna a lista de endereços.</td>
        <td>
          <pre><code class="json">
[
  {
    "id": 1,
    "street": "Rua das Flores",
    "number": "123",
    "city": "Belo Horizonte",
    "state": "MG",
    "zipCode": "30100-000"
  }
]
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>GET /address/{id}</kbd></td>
        <td>Retorna os detalhes de um endereço.</td>
        <td>
          <pre><code class="json">
{
  "id": 1,
  "street": "Rua das Flores",
  "number": "123",
  "city": "Belo Horizonte",
  "state": "MG",
  "zipCode": "30100-000"
}
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>PUT /address/{id}</kbd></td>
        <td>Atualiza os dados de um endereço.</td>
        <td>
          <pre><code class="json">
{
  "message": "Endereço atualizado com sucesso"
}
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>DELETE /address/{id}</kbd></td>
        <td>Remove um endereço.</td>
        <td>
          <pre><code class="json">
{
  "message": "Endereço removido com sucesso"
}
          </code></pre>
        </td>
      </tr>
    </tbody>
  </table>

<h3>📊 Registro de Movimentação</h3>
  <table>
    <thead>
      <tr>
        <th>Route</th>
        <th>Description</th>
        <th>Response Example</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><kbd>POST /log</kbd></td>
        <td>Registra a entrada de um veículo.</td>
        <td>
          <pre><code class="json">
{
  "id": 1,
  "vehicleId": 1,
  "establishmentId": 1,
  "entryTime": "2025-02-16T14:30:00",
  "exitTime": null
}
          </code></pre>
        </td>
      </tr>
      <tr>
        <td><kbd>PUT /log/{id}</kbd></td>
        <td>Registra a saída de um veículo.</td>
        <td>
          <pre><code class="json">
{
  "id": 1,
  "vehicleId": 1,
  "establishmentId": 1,
  "entryTime": "2025-02-16T14:30:00",
  "exitTime": "2025-02-16T18:00:00"
}
          </code></pre>
        </td>
      </tr>
    </tbody>
  </table>

# 📫 Contribua

Contribuições para este projeto são bem-vindas! Siga os passos abaixo para começar:

## 1. Clone o Repositório

Primeiro, clone o repositório para a sua máquina local:

1. `git clone https://github.com/pedro-henrique1/estacionamento_api.git`
2. `git checkout -b feature/NAME`
3. Siga os padrões de commit
4. Abra um Pull Request explicando o problema resolvido ou recurso feito, se existir, anexe a captura de tela de
   modificações visuais e aguarde a revisão!

### Documentações que podem ajudar

[📝 Como criar um Pedido de Puxar](https://www.atlassian.com/br/git/tutorials/making-a-pull-request)

[💾 Commit pattern](https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716)


