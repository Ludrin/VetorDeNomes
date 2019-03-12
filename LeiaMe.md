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
