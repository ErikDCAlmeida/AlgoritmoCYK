# AlgoritmoCYK
## Execução do Programa:
* Ao abir o projeto, necessário apenas executar (caso use o VSCode, apertar apenas **F5** no arquivo de nome **App.java**).
* Ao executar o projeto, aparecerá uma interface no qual você poderá procurar e escolher o arquivo **.TXT** que conterá a gramática.
* Logo após você precisará informar a palavra que deseja verificar.
* Por fim, o resultado aparecerá para você em uma interface que facilitará sua visualização do resultado, e no qual você poderá informar se quer testar mais palavras ou apenas fechar o programa, junto com a tabela de teste da palavra.

# Detalhes Obrigatórios do Programa
## Formato do .TXT e Gramática:
* Obrigatório estar na FNC (Forma Normal de Chomsky) como no exemplo a seguir e obrigatório estar no seguinte formato:

&nbsp;
S => XB | AB

&nbsp;
X => AS

&nbsp;
A => a

&nbsp;
B => b

* **Utilize exatamente os símbolo => e |**. Outros diferentes poderão afetar a execução, tome muito cuidado com isso. O símbolo => indica qual não-terminal é possível chegar de acordo com os seus não-terminais ou terminais do lado direito. O | é a separação dos não-terminais ou terminais. Observe que há espaços que também separação um item do outro, lembre-se de usá-los para que seu programa não seja prejudicado.
* O arquivo deve estar apenas e exclusivamente com a gramática dentro dele, nada mais que isso, pois poderá afetar a execução do programa.
* Exemplo de arquivo **.TXT** para usar: <https://github.com/ErikDCAlmeida/AlgoritmoCYK/blob/master/ArquivoTeste.txt>

## Como escrever a palavra:
* Para cada parte da palavra, você precisará dar espaço, por exemplo: 
1. Para uma palavra do tipo: **abaab**, digite da seguinte forma na parte que pede a palavra: **a b a a b**. Utilizando de apenas de 1 espaço de separação, se utilizar mais que um pode dar problema na linguagem e o resultado poderá não ser satisfatório.

# Conclusão
#### De resto é tudo completamente intuitivo. A interface lhe indicará o que precisará ser feito e lhe mostrará a melhor forma de executar o seu programa. 