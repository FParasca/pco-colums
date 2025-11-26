## 📄 Documento para Copiar e Colar (README.md)

Aqui está o conteúdo do `README.md` formatado para ser copiado e colado diretamente no seu repositório Git, descrevendo o projeto com base no PDF fornecido.

```markdown
# 🧩 Projeto PCO: Jogo Columns - 2025/2026

## 🎯 Objetivo do Projeto

[cite_start]O objetivo final deste trabalho de Programação Centrada em Objetos (PCO) é aplicar os conhecimentos adquiridos nas aulas [cite: 6][cite_start], construindo várias classes e interfaces em Java que são necessárias para executar o programa da classe `PCOMain` fornecida[cite: 42].

---

## 🎮 O Jogo Columns

[cite_start]O Columns é um jogo de puzzle criado em 1989[cite: 8]. [cite_start]O jogador coloca peças de 3 símbolos diferentes numa área rectangular (20 linhas x 12 colunas)[cite: 8, 9].

### Regras Principais

* [cite_start]**Peças:** Consistem em 3 símbolos diferentes que caem do topo[cite: 9].
* [cite_start]**Movimento:** O jogador pode deslocar a peça para a esquerda ou direita e alterar a ordem dos símbolos[cite: 10].
* [cite_start]**Eliminação:** Se, após a peça "aterrar", existirem 3 ou mais símbolos contíguos do mesmo tipo (horizontal, vertical ou diagonal), eles desaparecem[cite: 11].
* **Acomodação em Cadeia:** Símbolos que estavam suspensos caem. [cite_start]Se essa queda causar novas eliminações, o processo repete-se até não haver mais eliminações[cite: 12, 13].

### Tipos de Jogo e Pontuação

| Tipo de Jogo | Pontuação por Jogada Válida | Pontuação por Eliminação | Condição de Fim de Jogo |
| :--- | :--- | :--- | :--- |
| **`SingleScoreGame`** | [cite_start]10 pontos[cite: 141]. | [cite_start]Nenhuma (só contabiliza a realização da jogada)[cite: 116, 123]. | [cite_start]A área de jogo está completamente vazia **ou** não cabe uma peça em nenhuma coluna[cite: 116, 127]. |
| **`MultipleRewardGame`** | [cite_start]10 pontos[cite: 141]. | [cite_start]**Pontuação com Bónus** [cite: 142][cite_start]: 200 pts (base por 3 símbolos) + 50 pts (por símbolo adicional) [cite: 143, 145] [cite_start]**mais** bónus de eliminação em cadeia (2ª sequência x2, 3ª sequência x3, etc.)[cite: 146, 147, 148]. | [cite_start]Não existe nenhuma coluna onde ainda caiba uma peça[cite: 106]. |

---

## 🛠️ Estrutura e Classes do Projeto

[cite_start]O projeto utiliza o princípio de design **"Programar para interfaces"**[cite: 28].

### 1. Classes e Interfaces Fornecidos (NÃO fazer)

[cite_start]Os seguintes tipos de dados já são fornecidos[cite: 55, 69]:

* [cite_start]**Interfaces:** `Symbol`[cite: 55].
* [cite_start]**Enumerados:** `Hearts`, `Balls`, `Signs` (implementam `Symbol`)[cite: 56].
* [cite_start]**Classes de Componentes:** `Piece`[cite: 57].
* [cite_start]**Classes de Lógica Central:** `PlayArea` (chama o eliminador e o acomodador)[cite: 59, 60].
* [cite_start]**Implementações Avançadas:** `FatalFallAccomodator` [cite: 66, 294] [cite_start]e `PatternEliminator`[cite: 67, 290].
* [cite_start]**Main Class:** `PCOMain`[cite: 295].

### 2. Classes e Interfaces a Construir (TAREFA DO ALUNO)

[cite_start]Os alunos devem construir os seguintes tipos de dados[cite: 69]:

#### 📚 Interfaces a Definir

| Interface | Constantes | Métodos Principais |
| :--- | :--- | :--- |
| **`Game`** | [cite_start]`SIZE_OF_PIECE = 3` [cite: 74] | [cite_start]`linesInGrid()`, `permutatePiece()`, `placePiece()`, `generatePiece()`, `finished()`, `score()` [cite: 76-83, 86]. |
| **`Eliminator`** | | [cite_start]`eliminateSequence(Symbol[] seq, int blockSize, Symbol nothing)`[cite: 87, 88]. |
| **`Accomodator`** | | [cite_start]`accomodate(Symbol[] seq, Symbol nothing)`[cite: 89, 90]. |

#### 🏗️ Classes a Implementar

* [cite_start]**`AbstractGame`** (Classe Abstrata): Implementa `Game`[cite: 92]. [cite_start]Define a lógica comum, como o construtor, e implementa métodos como `linesInGrid()`, `generatePiece()`, `finished()` (padrão)[cite: 95, 101, 102].
* [cite_start]**`MultipleRewardGame`** (Subclasse de `AbstractGame`): Implementa a lógica de pontuação do tipo "Multiple Reward"[cite: 106, 110].
* [cite_start]**`SingleScoreGame`** (Subclasse de `AbstractGame`): Implementa a lógica de pontuação do tipo "Single Score" e redefine o método `finished()`[cite: 116, 127].
* [cite_start]**`SimpleEliminator`** (Implementa `Eliminator`): Sabe eliminar sequências de símbolos repetidos de tamanho **`blockSize` ou mais**[cite: 129, 133].
* [cite_start]**`SimpleAccomodator`** (Implementa `Accomodator`): Sabe acomodar uma sequência de símbolos de modo a fechar os "buracos" (`nothing`)[cite: 135, 139].

---

## 📁 Estrutura de Código Sugerida

Para uma boa estruturação, sugere-se a seguinte organização, onde a classe principal (`PCOMain.java`) fica na raiz e as classes de lógica e componentes são separadas em pastas:

```

.
├── PCOMain.java
├── Game.java               \<-- Interfaces a implementar
├── Eliminator.java
├── Accomodator.java
├── logica/                 \<-- Classes de Lógica/Jogo (AbstractGame, SimpleEliminator, etc.)
│   ├── AbstractGame.java
│   ├── MultipleRewardGame.java
│   ├── SingleScoreGame.java
│   ├── SimpleEliminator.java
│   └── SimpleAccomodator.java
└── componentes/            \<-- Classes de Elementos/Modelos/Lógica Complexa
├── FatalFallAccomodator.java  (Fornecida)
├── PatternEliminator.java     (Fornecida)
├── PlayArea.java              (Fornecida)
├── Piece.java                 (Fornecida)
└── ... (Enumerados Fornecidos)

```

**⚠️ Atenção:** Para que esta estrutura funcione, os arquivos dentro das pastas `logica/` e `componentes/` devem conter a declaração `package` no topo (ex: `package logica;`).

---

## 📦 Regras de Entrega

* [cite_start]**Comentários:** É obrigatório comentar condignamente as vossas classes (cabeçalhos Javadoc, `@author`, `@param`, `@return`, etc.)[cite: 299, 300, 301].
* [cite_start]**Conteúdo da Entrega:** Um ficheiro `.zip` contendo **somente** as classes e interfaces que vos pediram para fazer[cite: 302].
* [cite_start]**Nome do Ficheiro:** `PCOxxx.zip` (onde `xxx` é o número do vosso grupo)[cite: 303].
* [cite_start]**Data Limite:** 4 de Dezembro[cite: 305].
```

Gostaria de ajuda para começar a definir a interface `Game` ou outra classe que precise de criar?
