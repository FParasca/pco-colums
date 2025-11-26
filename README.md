# Enunciado do Projeto de PCO: Jogo Columns

## Objetivo do Projeto 🎯

O objetivo final deste trabalho de Programação Centrada em Objetos é pôr em prática os conhecimentos que vão sendo adquiridos nas aulas. 
A vossa tarefa é construir, em Java, vários dos tipos de dados apresentados no diagrama de classes fornecido, que são necessários para executar o programa da classe `PCOMain`.

---

## Contexto do Jogo Columns 🕹️

O Columns é um jogo de puzzle onde o jogador coloca peças compostas por **3 símbolos diferentes** numa área rectangular de **20 linhas com 12 colunas**.

### Mecânicas Principais

* **Peças:** Caem do topo da área de jogo.
* **Ações do Jogador:** Deslocar a peça para a esquerda ou para a direita e alterar a ordem dos símbolos.
* **Eliminação:** Se existirem **3 ou mais símbolos contíguos** do mesmo tipo (horizontal, vertical ou diagonal), eles desaparecem.
* **Acomodação:** Peças suspensas caem. O processo repete-se em cadeia se a queda causar novas eliminações.

### Tipos de Jogo

| Tipo de Jogo | Pontuação | Condição de Fim de Jogo |
| :--- | :--- | :--- |
| **`SingleScoreGame`** | 10 pontos por jogada válida (não conta eliminações). | Área completamente vazia **ou** nenhuma coluna tem espaço para uma peça. |
| **`MultipleRewardGame`** | 10 pontos por jogada + Bónus por eliminação e por cadeia (Ex: 2ª sequência x2, 3ª sequência x3). | Nenhuma coluna tem espaço para uma peça. |

---

## Componentes a Construir 🏗️

O princípio de design **"Programar para interfaces"** deve ser seguido.

### 1. Interfaces a Implementar

| Interface | Propriedades e Métodos |
| :--- | :--- |
| **`Game`** | Define `static final int SIZE_OF_PIECE = 3`. Contém métodos como `linesInGrid()`, `permutatePiece()`, `placePiece()`, `generatePiece()`, `finished()`, `score()`, e `registerPlayScore()`. |
| **`Eliminator`** | Define o método `int eliminateSequence (Symbol[] seq, int blockSize, Symbol nothing)`. |
| **`Accomodator`** | Define o método `void accomodate (Symbol[] seq, Symbol nothing)`. |

### 2. Classes a Implementar

| Classe | Descrição |
| :--- | :--- |
| **`AbstractGame`** (Abstrata) | Implementa `Game`. Define a lógica comum, o construtor principal, e implementa métodos como `linesInGrid()`, `generatePiece()`, `finished()` (padrão), e `toString()`
, deixando métodos de pontuação por implementar. |
| **`MultipleRewardGame`** | Subclasse de `AbstractGame`. Implementa a lógica de pontuação com múltiplos bónus. |
| **`SingleScoreGame`** | Subclasse de `AbstractGame`. Implementa a pontuação simples e redefine `finished()` para verificar se a área está vazia. |
| **`SimpleEliminator`** | Implementa `Eliminator`. Sabe eliminar sequências de símbolos repetidos de tamanho **`blockSize` ou mais**. |
| **`SimpleAccomodator`** | Implementa `Accomodator`. Sabe acomodar a sequência para "fechar os buracos" (`nothing`). |

### Componentes Fornecidos (NÃO FAZER)

* `Symbol`, `Hearts`, `Balls`, `Signs`
* `Piece`, `PlayArea`
* `FatalFallAccomodator`, `PatternEliminator`
* `PCOMain`

---

## Entrega do Projeto 📦

* **Comentários:** É obrigatório comentar condignamente as vossas classes (cabeçalhos Javadoc com `@author`, `@param`, `@return`, etc.).
* **Ficheiro Zip:** Entregar um ficheiro zip contendo **somente** as classes e interfaces que vos pediram para fazer.
* **Nome do Ficheiro:** `PCOxxx.zip` (onde `xxx` é o número do vosso grupo).
