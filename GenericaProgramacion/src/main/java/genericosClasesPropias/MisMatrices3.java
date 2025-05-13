package genericosClasesPropias;

//casos retorno Generico
   //F1 mas detalles en MisMatrices2
public class MisMatrices3{
   public static <T extends Comparable> T getMenorElemtento(T[] a){ 
            if(a.length==0 || a==null)return null;  
            T elementoMenor=a[0];
             for (int i = 1; i < a.length; i++) {
                if(elementoMenor.compareTo(a[i])>0){
                    elementoMenor=a[i];
                }
            }

        return elementoMenor;
    }
    
  
}
 //f2 similar a f1, preferible mejor usar metodos estaticos
/*public class MisMatrices3{
   public <T extends Comparable> T getMenorElemtento(T[] a){ 
            if(a.length==0 || a==null)return null;  
            T elementoMenor=a[0];
             for (int i = 1; i < a.length; i++) {
                if(elementoMenor.compareTo(a[i])>0){
                    elementoMenor=a[i];
                }
            }

        return elementoMenor;
    }
    
  
}*/
/*public class MisMatrices3<T>{
    //ene st caso el extends peuyde quedar aca, o en el T de arribasi quremos restriungir a todos o aca si solo coupamos para este metodo
   public <T extends Comparable> T getMenorElemtento(T[] a){ //y segundo, aca al redfinir t,t podra tomar diferentes gfenericos y no sera el mimso que con el qeu se decalra la clase
            if(a.length==0 || a==null)return null;  
            T elementoMenor=a[0];
             for (int i = 1; i < a.length; i++) {
                if(elementoMenor.compareTo(a[i])>0){
                    elementoMenor=a[i];
                }
            }

        return elementoMenor;
    }
}*/

//f4 ahora si viendo que el t generico es pra todos los t
/*public class MisMatrices3<T extends Comparable>{
    //si aca redefinieramos T tampoco serivira ya todo el metodo ya que el comparteto nostirara error ya que de neuvo estariamos creando otro t difrerente al de la calse,y oasaria algo como en el f5
    //public <T> T getMenorElemtento(T[] a){
    public T getMenorElemtento(T[] a){ //en este caso tenemos de paso extende spara todos los T, y segundo el t del emtodo sera el mismo del de la clase
            if(a.length==0 || a==null)return null;  // por lo tanto ahora los argumentos deberan ser del mismo t definido en la casle porque ambos t son los ismo por que no hay redificniocion
            T elementoMenor=a[0];             //osea no psasreai como el static, ya que este t sera el mismo que el de la clase
             for (int i = 1; i < a.length; i++) {
                if(elementoMenor.compareTo(a[i])>0){
                    elementoMenor=a[i];
                }
            }

        return elementoMenor;
    }
}*/
//F5
/*public class MisMatrices3<T extends Comparable>{
  
   public static <T> T getMenorElemtento(T[] a){ 
            if(a.length==0 || a==null)return null;  
            T elementoMenor=a[0];           
             for (int i = 1; i < a.length; i++) {
                if(elementoMenor.compareTo(a[i])>0){//en este caso esta nomencaltura no serviria asi que no s eprobara siquiera
                    elementoMenor=a[i]; //ya que , si es etsatico se redefine t y por tanto un t diferente al t de la clase,
                }     //por tanto no serviria de nada ese extendes, y compare no serviria ya que el T de refenicion como digo es ootro y el t que se esta usando en el metodo es el t redificnido ,m asi que tocaria que fuera como estra el f6
            }

        return elementoMenor;
    }
}*/
//F6
//public class MisMatrices3<T extends Comparable>{//si lodejamos asi tanto como el parametro generico recibido como el del metodo que otro t diferente a este amos deben implemtenar comparable
   /* public class MisMatrices3<T>{ //ahoa si puede recibir cualquier genrico implemente o no comparable y nda tendfra que ver con el t recibido en el metodo el cual si debera de implementar comparable
   public static <T extends Comparable> T getMenorElemtento(T[] a){ 
            if(a.length==0 || a==null)return null;  
            T elementoMenor=a[0];           
             for (int i = 1; i < a.length; i++) {
                if(elementoMenor.compareTo(a[i])>0){
                    elementoMenor=a[i]; 
                }    
            }
        return elementoMenor;
    }
}*/