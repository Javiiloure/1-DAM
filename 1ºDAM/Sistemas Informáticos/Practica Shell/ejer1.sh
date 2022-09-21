#!\bin\bash
if [ $# -lt 2 ]
then
        echo Error en el número de argumemtos
else
        while 
                echo [Uno]Sumar argumentos multiplos de 3
                echo [Dos]Ficheros con permiso de escritura
                echo [Tres]Ocurrencias del nombre del script
                echo [Fin]Fin
                read opcion
                [ $opcion != Fin ]
        do
                case $opcion in
                [Uu]no|1) suma=0
                        for i
                        do
                                if [ $(expr $i % 3) -eq 0 ]
                                        then
                                                suma=$(expr $suma + $i)
                                fi
                        done
                        echo -e "\nLa suma de los multiplos de 3 es $suma \n";;
                [Dd]os|2)echo -e "\nIntroduce el nombre del fichero:"
                         read fichero
                         [ -w $fichero ] && echo El fichero $fichero tiene permisos de escritura || echo No existe ese fichero o no tiene permisoso de escritura;;
                [Tt]res|3) ocurrencias=0
                        until [ $# -eq 0 ]
                        do
                                echo -e "\nEl argumento a comparar es $1 \n"
                                if [ $0 = $1 ]
                                        then
                                                ocurrencias=$(expr $ocurrencias + 1)
                                fi
                                shift
                        done
                        echo El nombre del script coincide $ocurrencias con los argumentos del script;;
                *)      echo Opcion incorrecta;;
        esac
        done
        echo Fin del programa
fi
