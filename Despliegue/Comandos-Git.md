# Comandos de git para el entorno de trabajo
    git merge --ff-only origin/develop 

Usamos el comando de arriba para traer los commits de la rama develop
Esto sirve para cuando estemos trabajando en grupo y tengamos nuevos cambios, por ejemplo,
nuevos compañeros han solventado nuevas issus y pushean sus cambios a develop, nosotros queremos
los nuevos cambios en nuestra rama develop.

    git fetch --prune

Lo usaremos para sincronizar nuestro repositorio local con el remoto al eliminar referencias de respotiorios remotos que hemos creado.
