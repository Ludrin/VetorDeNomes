# Vetor de Palavras

Esse é um programa desenvolvido por Ernani Ricoy para o processo de seleção de desenvolvimento de software pela Yellow.rec. O programa foi desenvolvido em Java.

# Como usar

O pacote processVocabulary contém classes com métodos main. A classe ProcessSingleWordVocabulary processa dois arquivos de texto e o transforma em um vocabulário de palavras sequenciais únicas. A classe ProcessDoubleWordVocabulary trabalha de maneira similar à  primeira, porém com palavras sequenciais em dupla. Ambas as classes podem ser rodadas como aplicações Java normais.
O pacote bonus contêm a criação de vocabulários sequenciais únicas e duplas usando três arquivos.

# Decisões gerais
  - O nome do programa e esse arquivo Leia Me foram escritos em português para facilitar a identificação e uso, mas o código em si (variáveis, Javadoc, classes) foi feito em inglês.
  - O programa foi feito pensando em reaproveitar o máximo de código possível. A mesma solução funciona tanto para a sequência de letras únicas quanto em pares.
  - Por se tratar de uma prova técnica e pelo bem do entendimento Javadocs foram gerados para todos os métodos, inclusive os privados (mesmo sendo contra indicado por alguns padrões), para se explicar toda a lógica.
  - O princípio do "clean code" foi usado. Assim, variáveis, métodos e classes foram criados com nomes o mais descritivos possíveis e o uso de comentáios dentro dos métodos foi evitado (dentre outras práticas dessa filosofia).
  - Javadoc foi gerada ao final do desenvolvimento.

# Decisões técnicas

  - Para a sequência de caracteres em dupla existe a possibilidade do número de letras da frase ser ímpar. Nesse caso um dos elementos do vocabulário não teria um par. Como na descrição do programa não havia instruções sobre como prosseguir nessa situação foi optado que um dos elementos da sequência ímpar fique sem dupla.
  - A solução foi pensada em ser escalável e dinâmica. Assim, aterando a forma como os métodos são chamados pode-se obter resultads diferentes:
    - Contar quantas vezes as palavras da frase dos arquivos aparece somente em um vetor de inteiros ao invés de dois;
    - Ler os dados de três ou mais arquivos;
    - Ler os dados de somente um arquivo;
    - Dentre outros.
  - Java 8 foi usado sempre que aplicável.
  - O mínimo de iterações e laços de repetição foram usados para deixar a aplicação o mais leve possível. Dessa forma, muita da lógica foi feita com o uso de expressões regulares.

### Explicação do código

Segue uma explicação geral de como o código funciona. Os Javadocs podem ser consultados para mais detalhes técnicos.
