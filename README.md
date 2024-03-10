# Looking for Movies

Looking for Movies - App simples com o intuito de buscar por nomes dos filmes, séries e episódios, podendo adicionar a sua lista de favoritos.<br>
Esse é um aplicativo foi desenvolvido para fins de estudos da arquitetura com multi modulos e boas práticas no desenvolvimendo Android.<br> 
O App consome a API de filmes http://www.omdbapi.com/ (The Open Movie Database) para exibição das informações.

<h1>Estrutura</h1> <br>
O app está seguindo a arquitetura MVVM, baseado nos samples do Android https://github.com/android/nowinandroid/blob/main/docs/ModularizationLearningJourney.md<br> 
E possui os seguintes módulos:<br>

![rachel-Página-3 drawio (2)](https://github.com/rachellimaa/looking-for-movies/assets/11683116/75ca5d09-fb4d-4338-bd33-5a11f5ea4306) 

<h1>Observações</h1>
O aplicativo tem uma interface visual simples, mas com uma arquitetura bastante completa, utilizando View Binding, Navigation, injeção de dependencias com Koin<br>
Alguns testes unitários foram implementados nos módulos.<br>
Um GitHub action foi configurado para buildar o projeto e gerar a apk<br>

<h1>Melhorias</h1> 
A interface com usuário pode ser melhorada<br>
Adição de novas funcionalidades, como adição de filtros e adição da IA Gemini para buscar em que streamings esses filmes estão e demais dúvidas dos usuários.<br>  
Adição de assinatura na apk <br>
Publicar na loja da play store
