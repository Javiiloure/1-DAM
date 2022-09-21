#!\bin\bash

vacio(){
        for i
        do
                [ -f $i ] && cat scrip2.sh >> $i || echo No es un fichero
        done
}

primeras(){
        echo Introduzca el nombre del fichero:
        read fichero
        [ -f $fichero ] && head -5 $fichero || echo El fichero no existe o no tiene permisos de escritura
}

doble(){
        menor=$1
        mayor=$1
        for i
        do
                if [ $i -lt $menor ]
                then
                       menor=$i
                fi
                if [ $i -gt $mayor ]
                then
                       mayor=$i
                fi
        done
        for i
        do
                if [ $menor -lt $i && $mayor -gt $i ]
                then
                doble=$i*2
                echo $doble
                fi
        done
}

mitad () {
        if [ $(expr $* % 2) -eq 0 ]
        then
                mitad=$(expr $# / 2)
                echo $mitad
                mitad=$(expr mitad + 1)
                echo $mitad
        else
                mitad=$(expr $# / 2)
                echo $mitad
        fi
}

if [ $# -lt 3 ]
then
        echo Error en los argumentos
else
        while
                echo [V]Vacio
                echo [P]Primeras
                echo [D]Doble
                echo [M]Mitad
                echo [F]Fin
                read opcion
                [ $opcion != F ]
        do
                case $opcion in
                [Vv]) vacio;;
                [Pp]) primeras;;
                [Dd]) doble;;
                [Mm]) mitad;;
        esac
        done
        echo Fin del programa
fi

