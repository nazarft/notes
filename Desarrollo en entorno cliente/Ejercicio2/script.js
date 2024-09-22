/*
Objetivo: Practicar el encadenamiento de promesas.
Descripción: Crea tres funciones que simulen llamadas a la API, cada una de las cuales toma un argumento del resultado anterior:
getUser(): Devuelve { id: 1, name: 'Maria' } después de 1 segundo.
getPosts(userId): Devuelve un array de posts para ese userId después de 1.5 segundos.
getComments(postId): Devuelve comentarios para un post dado.
Desafío: Encadena las promesas usando .then(), y luego reescribe el código utilizando async/await.
*/
function getUser() {
    return new Promise((resolve)=>{
       setTimeout(()=>{
        resolve({id:1, name:"Maria"});
       },1000);
    });
}
function getPosts(userId) {
    return new Promise((resolve)=>{
        setTimeout(()=>{
            resolve(["post1", "post2","post3"]);
        },1500);
    });
}
function getComments(postId) {
    return new Promise((resolve) => {
        setTimeout(() => resolve(['Comment 1', 'Comment 2']), 1000);
    });
}
// Con promesas
getUser()
    .then(user=>{
        console.log('Usuario: ', user);
        return getPosts(user.id);
    }).then(posts => {
        console.log('Posts: ', posts);
       return getComments(posts[0]);
    }).then(comments =>console.log('Comentarios: ', comments))
    .catch(error=> console.log('Error: ', error));
// Con async/await

async function getData() {
    try{
        const user = await getUser();
        console.log('Usuario: ', user);

        const posts = await getPosts(user.id);
        console.log('Posts: ', posts);

        const comments = await getComments(posts[0]);
        console.log('Comments: ', comments);
    } catch(error) {
        console.log('Error: ', error);
    }
}
getData();