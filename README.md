# Vetor de Palavras

Esse � um programa desenvolvido por Ernani Ricoy para o processo de sele��o de desenvolvimento de software pela Yellow.rec. O programa foi desenvolvido em Java.

# Como usar

O pacote processVocabulary cont�m classes com m�todos main. A classe ProcessSingleWordVocabulary processa dois arquivos de texto e o transforma em um vocabul�rio de palavras sequenciais �nicas. A classe ProcessDoubleWordVocabulary trabalha de maneira similar � primeira, por�m com palavras sequenciais em dupla. Ambas as classes podem ser rodadas como aplica��es Java normais.
O pacote bonus cont�m a cria��o de vocabul�rios sequenciais �nicas e duplas usando tr�s arquivos.

# Decis�es gerais
  - O nome do programa e esse arquivo Leia Me foram escritos em portugu�s para facilitar a identifica��o e uso, mas o c�digo em si (vari�veis, Javadoc, classes) foi feito em ingl�s.
  - O programa foi feito pensando em reaproveitar o m�ximo de c�digo poss�vel. A mesma solu��o funciona tanto para a sequ�ncia de letras �nicas quanto em pares.
  - Por se tratar de uma prova t�cnica e pelo bem do entendimento Javadocs foram gerados para todos os m�todos, inclusive os privados (mesmo sendo contra indicado por alguns padr�es), para se explicar toda a l�gica.
  - O princ�pio do "clean code" foi usado. Assim, vari�veis, m�todos e classes foram criados com nomes o mais descritivos poss�veis e o uso de coment�ios dentro dos m�todos foi evitado (dentre outras pr�ticas dessa filosofia).
  - Javadoc foi gerada ao final do desenvolvimento.

# Decis�es t�cnicas

  - Para a sequ�ncia de caracteres em dupla existe a possibilidade do n�mero de letras da frase ser �mpar. Nesse caso um dos elementos do vocabul�rio n�o teria um par. Como na descri��o do programa n�o havia instru��es sobre como prosseguir nessa situa��o foi optado que um dos elementos da sequ�ncia �mpar fique sem dupla.
  - A solu��o foi pensada em ser escal�vel e din�mica. Assim, aterando a forma como os m�todos s�o chamados pode-se obter resultads diferentes:
    - Contar quantas vezes as palavras da frase dos arquivos aparece somente em um vetor de inteiros ao inv�s de dois;
    - Ler os dados de tr�s ou mais arquivos;
    - Ler os dados de somente um arquivo;
    - Dentre outros.
  - Java 8 foi usado sempre que aplic�vel.
  - O m�nimo de itera��es e la�os de repeti��o foram usados para deixar a aplica��o o mais leve poss�vel. Dessa forma, muita da l�gica foi feita com o uso de express�es regulares.

### Explica��o do c�digo

Segue uma explica��o geral de como o c�digo funciona. Os Javadocs podem ser consultados para mais detalhes t�cnicos.

1. Os arquivos com as frases desejadas s�o carregados utilizando os m�todos da classe _FileUtils_. Alguns arquivos de teste est�o na pasta _resources_.
2. O conte�do do arquivo recebe os seguintes tratamentos:
    1. Removido de espa�os em excesso
    2. Removido de marca��o, como pontos de interroga��o, pontos finais, v�rgulas...
    3. Todas as letras s�o convertidas para upper case
    4. As palavras s�o separadas ou sozinhas ou em dupla, dependendo de qual m�todo for chamado. _createSingleWordArray_ separa as palavras sozinhas e _createDoubleWordArray_ em dupla
3. Uma quantidade n de vetores de palavras s�o passadas para o m�todo _createVocabulary_. Os vetores s�o unidos e transferidos para um Set<String>, o que elimina automaticamente as palavras repetidas.
    1. Opcionalmente � poss�vel remover palavras indesejadas (stop words) do vocabul�rio. O m�todo _removeStopWords_ recebe o vocabul�rio e as stop words como Set<String> e realiza esse tratamento
    2. Um dos arquivos da pasta _resources_ cont�m uma stop word em cada linha. Plavras podem ser adicionadas e removidas livremente. Um dos m�todos da classe _FileUtils_, _getFileContentAsStringSet_, l� cada linha e salva em um elemento do Set<String>
    3. Esse tratamento foi feito na classe _ProcessSingleWordVocabulary_ para demonstra��o
4. Um vetor de n�meros inteiros � criado para cada arquivo lido cujo tamanho � igual ao tamanho do vocabul�rio.
5. O m�todo _countWordsInVocabulary_ � chamado para cada vetor de n�meros inteiros. O vocabul�rio � percorrido para cada palavra de cada arquivo e, caso haja ocorr�ncia, � adicionado 1 no �ndex do vetor de inteiros correspondente.