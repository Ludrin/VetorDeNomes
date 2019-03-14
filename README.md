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

1. Os arquivos com as frases desejadas são carregados utilizando os métodos da classe _FileUtils_. Alguns arquivos de teste estão na pasta _resources_.
2. O conteúdo do arquivo recebe os seguintes tratamentos:
    1. Removido de espaços em excesso
    2. Removido de marcação, como pontos de interrogação, pontos finais, vírgulas...
    3. Todas as letras são convertidas para upper case
    4. As palavras são separadas ou sozinhas ou em dupla, dependendo de qual método for chamado. _createSingleWordArray_ separa as palavras sozinhas e _createDoubleWordArray_ em dupla
3. Uma quantidade n de vetores de palavras são passadas para o método _createVocabulary_. Os vetores são unidos e transferidos para um Set<String>, o que elimina automaticamente as palavras repetidas.
    1. Opcionalmente é possível remover palavras indesejadas (stop words) do vocabulário. O método _removeStopWords_ recebe o vocabulário e as stop words como Set<String> e realiza esse tratamento
    2. Um dos arquivos da pasta _resources_ contêm uma stop word em cada linha. Plavras podem ser adicionadas e removidas livremente. Um dos métodos da classe _FileUtils_, _getFileContentAsStringSet_, lê cada linha e salva em um elemento do Set<String>
    3. Esse tratamento foi feito na classe _ProcessSingleWordVocabulary_ para demonstração
4. Um vetor de números inteiros é criado para cada arquivo lido cujo tamanho é igual ao tamanho do vocabulário.
5. O método _countWordsInVocabulary_ é chamado para cada vetor de números inteiros. O vocabulário é percorrido para cada palavra de cada arquivo e, caso haja ocorrência, é adicionado 1 no índex do vetor de inteiros correspondente.