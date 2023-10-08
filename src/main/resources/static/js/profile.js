document.addEventListener("DOMContentLoaded", function() {
    // URL de la solicitud GET
    const url = 'http://localhost:8082/profileUser/20';

    // Realizar la solicitud GET
    fetch(url)
      .then(response => response.json())
      .then(data => {
        // Obtener la URL de la foto de perfil del JSON (reemplaza 'urlFotoPerfil' con el campo real en tu JSON)
        console.log(data);
        const urlFotoPerfil = data.fotoPerfil;

        // Cambiar el src de la imagen con id "fotoPerfil"
        const fotoPerfil = document.getElementById('fotoPerfil');
        fotoPerfil.src = urlFotoPerfil;
      })
      .catch(error => console.error('Error al realizar la solicitud:', error));
  });

  // Obtén el contenedor donde agregarás los posts
const postsContainer = document.getElementById('postsContainer');

// Realiza el llamado a la API y procesa los datos
fetch('http://localhost:8082/postsUser/byProfileUserId/20')
    .then(response => response.json())
    .then(posts => {
        // Itera sobre los posts y crea elementos HTML dinámicamente
        posts.forEach(post => {
            // Crea un contenedor de fila
            const rowContainer = document.createElement('div');
            rowContainer.classList.add('row', 'g-2');

            // Crea un contenedor de columna para la imagen
            const imageContainer = document.createElement('div');
            imageContainer.classList.add('col-12', 'mb-2');

            // Crea la imagen y configura su atributo src
            const image = document.createElement('img');
            image.src = post.imagen;
            image.alt = 'Imagen del post';
            image.classList.add('w-100', 'rounded-3');

            // Agrega la imagen al contenedor de columna de la imagen
            imageContainer.appendChild(image);

            // Agrega el contenedor de columna de la imagen al contenedor de fila
            rowContainer.appendChild(imageContainer);

            // Crea un contenedor de fila para el tema y subtema
            const textContainer = document.createElement('div');
            textContainer.classList.add('row', 'g-2');

            // Crea una columna para el tema y subtema
            const textColumn = document.createElement('div');
            textColumn.classList.add('col-12');

            // Crea un título h3 para el tema y un párrafo para el subtema
            const title = document.createElement('h3');
            title.textContent = post.tema;

            const subtitle = document.createElement('p');
            subtitle.textContent = post.subtema;

            // Agrega el título y el párrafo al contenedor de columna de texto
            textColumn.appendChild(title);
            textColumn.appendChild(subtitle);

            // Agrega el contenedor de columna de texto al contenedor de fila de texto
            textContainer.appendChild(textColumn);

            // Agrega el contenedor de fila de texto al contenedor principal
            rowContainer.appendChild(textContainer);

            // Agrega el contenedor principal al contenedor de posts
            postsContainer.appendChild(rowContainer);
        });
    })
    .catch(error => console.error('Error al obtener los posts:', error));