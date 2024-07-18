<div align="center">

![Static Badge](https://img.shields.io/badge/Status-Projeto%20em%20constru%C3%A7%C3%A3o-%23F8BA00)

# E-commerce

<img src="https://github.com/user-attachments/assets/059ea769-fff6-4cb3-b559-3cbaaa7601e0" width="200" height="200"/>

</div>

## Apresentação do aplicativo

### Tecnologias - recursos utilizados nesse aplicativo:
<ul>
  <li><b>Kotlin</b>;</li>
  <li><b>Navigation Component:</b> Uma activity contém vários fragments em vez de criar várias activities;</li>
  <li><b>Firebase Firestore:</b> Banco de dados para o sistema  Firebase Storage / Firebase Cloud Messaging;</li>
  <li><b>Firebase Auth:</b> Gerenciamento de contas / Login e registros;</li>
  <li><b>MVVM & LiveData:</b> Separe o código lógico das visualizações e salve o estado, caso a configuração da tela seja alterada;</li>
  <li><b>Coroutines:</b> faça algum código em segundo plano;</li>
  <li><b>View Binding:</b> Em vez de inflar as visualizações manualmente, a vinculação de visualizações cuidará disso;</li>
  <li><b>Glide:</b> Capture imagens e carregue-as no imageView.</li>
</ul>

## Benefícios do Kotlin:
<p>
São vários os benefícios do Kotlin, alguns estão listados aqui:
</p>
<ul>
  <li>
    <b>Menos código e maior legibilidade:</b> Gasta-se menos tempo escrevendo código em <a href="https://kotlinlang.org/docs/android-overview.html">Kotlin</a>;
  </li>
  <li>
    <b>Menos erros comuns:</b> Aplicativos em Kotlin têm 20% menos probabilidade de travar <a href="https://medium.com/androiddevelopers/fewer-crashes-and-more-stability-with-kotlin-b606c6a6ac04">com base nos dados do Google</a>;
  </li>
  <li>
     <b>Suporte a Kotlin em bibliotecas Jetpack:</b> O Jetpack Compose é o kit de ferramentas moderno recomendado pelo Android, para criar UI nativa em Kotlin. As extensões KTX, adicionam recursos da linguagem Kotlin, como <i>coroutines</i>, <i>extension functions</i>, <i>lambdas</i> e <i>parameters</i>.
  </li>
  <li>
     <b>Suporte para desenvolvimento multiplataforma:</b> O Kotlin Multiplataforma permite o desenvolvimento não apenas para Android, mas também para iOS, backend e web. Algumas bibliotecas do Jetpack já são multiplataforma.
  </li>
  <li>
     <b>Linguagem e ambiente maduros:</b> Desde sua criação em 2011, o Kotlin está em desenvolvimento contínuo e, atualmente está perfeitamente integrado ao Android Studio.
  </li>
  <li>
     <b>Interoperabilidade com Java:</b> Você pode usar Kotlin e Java juntos sem problemas.
  </li>
  <li>
     <b>Fácil aprendizado:</b> Kotlin é fácil de aprender, principalmente para desenvolvedores Java.
  </li>
  <li>
     <b>Comunidade:</b> Kotlin tem grande suporte e muitas contribuições da comunidade.
  </li>
</ul>

## Firebase:
<p>
  <a href="https://en.wikipedia.org/wiki/Firebase">Firebase</a> é um conjunto de serviços de computação em nuvem de backend e plataformas de desenvolvimento de aplicativos fornecidos pelo Google. Hospeda bancos de dados, serviços, autenticação e integração para aplicativos incluindo Android, iOS, JavaScript, Node.js, Java, Unity, PhP e C++.
</p>

### Firestore:
<p>
  É um banco de dados de documentos compatível com JSON, que oferece grande capacidade de consulta.
</p>

### Firebase Auth:
<p>
  O Firebase Authentication, tem como objetivo facilitar a construção de sistemas de autenticação seguros, ao mesmo tempo em que melhora a experiência de login para os usuários.
</p>

### Firebase Storage:
<p>
  É um serviço de armazenamento de objetos, simples e econômico, criado pelo Google. Os Firebase SDKs for Cloud Storage, adicionam segurança do Google a uploads e downloads de arquivos.
</p>

### Firebase Cloud Messaging:
<p>
  O Firebase Cloud Messaging fornece uma conexão confiável e com baixo consumo de bateria entre seu servidor e dispositivos, permitindo o envio e recebimento de mensagens e notificações.
</p>

### MVVM:
<p>
  <b>Model View View Model</b>: é uma arquitetura onde, na prática, a camada Model não se comunica com a View e nem a View se comunica com a Model, mas, a View conhece a ViewModel e se comunica com ela através do binding. A camada ViewModel é importante no fluxo, pois disponibiliza à View, uma lógica de apresentação e coordena as iterações da View com a Model, além de poder implementar a lógica de validação, garantindo a consistência dos dados.
  <a href="https://coodesh.com/blog/dicionario/o-que-e-arquitetura-mvvm/">O que é arquitetura MVVM?</a>
</p>

### Coroutines and Flows:
<p>
  Em coroutines, um fluxo é um tipo que pode emitir múltiplos valores sequencialmente, ao contrário de <b>suspend function</b>, que retorna apenas um único valor, ex.: um fluxo pode ser usado para receber atualizações em tempo real de um banco de dados.
  <a href="https://developer.android.com/kotlin/flow">Fluxos de Kotlin no Android</a>
</p>





