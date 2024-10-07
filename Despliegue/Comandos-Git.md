# Comandos de git para el entorno de trabajo
    git merge --ff-only origin/develop 

Usamos el comando de arriba para traer los commits de la rama develop
Esto sirve para cuando estemos trabajando en grupo y tengamos nuevos cambios, por ejemplo,
nuevos compañeros han solventado nuevas issus y pushean sus cambios a develop, nosotros queremos
los nuevos cambios en nuestra rama develop.

    git fetch --prune

Lo usaremos para sincronizar nuestro repositorio local con el remoto al eliminar referencias de respotiorios remotos que hemos creado.

    git merge --squash
    git commit -m "cambio"
Hacemos un merge-squash para que todos nuestros "micro-commits" se conviertan en un commit final que pushearemos a develop como una feat,
fix,etc.
    

## Situaciones que se pueden dar en un entorno de trabajo

1- Alguien ha hecho un commit en el último momento y cuando vas a pushear tu trabajo tienes error 
ya que tienes commits por traerte de origin/develop.

Para solucionarlo: 

        git fetch
        git switch develop
        git rebase origin/develop
Y a partir de aquí seguimos con nuestro trabajo habitual.
