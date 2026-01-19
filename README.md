# 🚀 Projeto Banco em Java

## 📌 Descrição
Este projeto simula um sistema bancário simples, desenvolvido em Java, com foco em aplicar os pilares da Programação Orientada a Objetos (POO): Abstração, Encapsulamento, Herança e Polimorfismo.

O sistema permite:
- Cadastro de clientes
- Criação de contas
- Depósitos, saques e transferências
- Busca de clientes e contas
- Exibição de saldos iniciais e finais

---

## 🧩 Pilares da POO aplicados

🔹 **Abstração**
- Classes Cliente, Conta e Banco representam entidades reais do domínio bancário.
- Cada classe possui atributos e métodos que refletem características e comportamentos do mundo real.

🔹 **Encapsulamento**
- Todos os atributos são privados (`private`).
- O acesso é feito por meio de getters e setters, com validações (ex.: saldo não pode ser negativo, CPF não pode ser vazio).
- Isso protege a integridade dos objetos e evita manipulação incorreta.

🔹 **Herança**
- Pode ser evoluído criando subclasses de Conta, como ContaCorrente e ContaPoupanca.
- Cada uma pode sobrescrever métodos como `sacar()` com regras específicas (ex.: cheque especial na corrente, restrição de saldo na poupança).

🔹 **Polimorfismo**
- Métodos como `sacar()` e `depositar()` podem ser sobrescritos nas subclasses de Conta.
- O mesmo método pode ter comportamentos diferentes dependendo do tipo de conta.

---
