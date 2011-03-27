import java.util.Scanner;
import java.text.NumberFormat;

class Matriz2{
	Scanner op = new Scanner(System.in);
	private int j, i,n,diagPrinc,diagSecond,sarrus,operacoesValor,xb,yb;
	private int x,y;
	private int matriz[][],matrizB[][],matrizresult[][];	

	void principalMenu(){	//ok
		int princMenu;
		System.out.println("Seja Bem Vindo \nDeseja trabalhar com :");
		System.out.println("1 - Matriz"); //ok
		System.out.println("2 - Determinante"); //ok
		System.out.println("0 - Sair");//ok
		princMenu=op.nextInt();
		menuPrinc : switch(princMenu){
		case(0):
			break menuPrinc;
		case(1):
			escolhaMatriz();
			break;
		case(2):
			ordemMatriz();
			criarMatriz();
			mostrarMatriz();
			criarMenu();
			break;
		}
		
	}
	
	void redefinirOrdemMatriz(){ // ok
		int redf;
		System.out.println("Deseja Redefinir a ordem de sua Matriz?");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		redf=op.nextInt();
		switch(redf){
		case(1):
			ordemMatriz();
			criarMatriz();
			mostrarMatriz();
			criarMenu();
			break;
		case(2):
			break;
		}
		
	}
	
	void ordemMatriz(){		//ok
		System.out.print("Digite o número de linhas: ");
		x=op.nextInt();
		System.out.print("Digite o numero de colunas: ");
		y=op.nextInt();
		verificaLinhasColunas();
		setMatriz();
	}
	
	void ordemMatrizB(){	//ok
		ordemMatriz();
		System.out.print("Digite o número de linhas de B: ");
		xb=op.nextInt();
		System.out.print("Digite o numero de colunas de B: ");
		yb=op.nextInt();
		verificaLinhasColunas();
		setMatrizB();
		
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	void tipoMatriz(){
		int sn;
		System.out.println("Gostaria de saber o tipo de qual matriz?");
		System.out.println("1 - A");
		System.out.println("2 - B");
		sn=op.nextInt();
		if(sn==1) {
		if(x==1){
			System.out.println("Esta matriz e do tipo: LINHA"); //ok
		}
		if(y==1){
			System.out.println("Esta matriz e do tipo: COLUNA"); //ok
		}
		if(x==y ){
			System.out.println("Esta matriz e QUADRADA");	//ok
		}
		if(x==0 && y==0){
			System.out.println("Não é Matriz"); //ok
		}
				//elementos nao pertecentes a diagonal principal sao 0 	ok
			int verif=0;
		 	for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				if(i==j && matriz[i][j]==0){
					verif++;
				}
		}
		 	}
			if(x*y-x==x*y){
				System.out.println("Esta matriz e DIAGONAL");	//ok
			}
			
				//elementos diagonal principal = 1  ok
			int verif2=0;
		 	for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				if(i==j && matriz[i][j]==1){
					verif2++;
				}
		}
		 	}
			if(verif2==x){
				System.out.println("Esta matriz e IDENTIDADE");	//ok
			}
				//matriz transpota VERIFICAR
			int verif3=0;
			if(x==yb && y==xb){
				for(i=0;i<x;i++){
					for(j=0;i<y;i++){
						for(int ib=0;ib<xb;ib++){
							for(int jb=0;jb<yb;jb++){
								if(matriz[i][j]==matrizB[ib][jb]){
									verif3++;
		
							}
						}
					}
				}
			}
				//if(verif3==)
				//System.out.println("Matriz B e a transposta de A");
		}

						/* codigos a serem validados
		if(//elementos simetricos a diagonal principal sao IGUAIS){
			System.out.println("Esta matriz e SIMETRICA");
		}
		if(//elementos simetricos a diagonal principal sao OPOSTOS(4 -4)){
			System.out.println("Esta matriz e ANTI-SIMETRICA");
		}
		if(//matriz quadrada em que TODOS os elementos ABAIXO da diagonal principal sao NULOS){
			System.out.println("Esta matriz e TRIANGULAR SUPERIOR");
		}
		if(//matriz quadrada em que TODOS os elementos ACIMA da diagonal principal sao NULOS){
			System.out.println("Esta matriz e TRIANGULAR INFERIOR");
		}
		*/
		if(x==xb && y==yb){ //ok
			int verif11=0;
			for(i=0;i<x;i++){
				for(j=0;j<y;j++){
					if(matriz[i][j]==matrizB[i][j]){
						verif11++;
					}
				}
			}
			if(verif11==x*y){
				System.out.println("Matriz A e B sao IGUAIS");	//ok
			}						
		}
	}
		
		
			// Validacao Matriz B
		if(sn==2) {
			if(xb==1){
				System.out.println("Esta matriz e do tipo: LINHA"); //ok
			}
			if(yb==1){
				System.out.println("Esta matriz e do tipo: COLUNA"); //ok
			}
			if(xb==yb){
				System.out.println("Esta matriz e QUADRADA");	//ok
			}
			if(xb==0 && yb==0){
				System.out.println("Esta matriz e NULA"); //ok
			}
		}
			
		
	}
	
	void operacoesMatriz(){ //falta determinar INVERSA e MULTIPLICAR pela MATRIZ B
		int operacoesMatriz;
		System.out.println("Oque deseja fazer com as duas matrizes?");
		System.out.println("1 - Somar"); //ok
		System.out.println("2 - Subtrair"); //ok
		System.out.println("3 - Multiplicar"); //calculos para 2x2 2x3 2x4 ok
		System.out.println("4 - Verificar o tipo da matriz"); //ok
		System.out.println("5 - Determinar a inversa"); 
		System.out.println("0 - Sair"); //ok
		operacoesMatriz=op.nextInt();
		
		operacoesMatrizValidacao : switch(operacoesMatriz){
		case(0):
			break operacoesMatrizValidacao;
		case(1):
			int oposto = 0;
			//matriz oposto quando o produto da 0
			if(x!=xb || y!=yb){
			System.out.println("Nao foi possivel fazer a operacao: A duas matrizes devem ser de mesma ORDEM");	
			operacoesMatriz();
			}	
			else {
				setMatrizResult();
			for(i=0;i<x;i++){
				for(j=0;j<y;j++){
					for(int ib=0;ib<xb;ib++){
						for(int jb=0;jb<yb;jb++){
							matrizresult[i][j]=matriz[i][j]+(matrizB[ib][jb]);
								if(matriz[i][j]==0){
									oposto++;
										if(oposto==(x*y)){
											System.out.println("A matriz A,B é oposto.");
								}
							}
						}
					}
				}
			}
			mostrarMatrizResult();
			}
			break;
		case(2):	// ok
			if(x!=xb || y!=yb){
				System.out.println("Nao foi possivel fazer a operacao: A duas matrizes devem ser de mesma ORDEM");
				operacoesMatriz();
				}	
				else {
					setMatrizResult();
				for(i=0;i<x;i++){
					for(j=0;j<y;j++){
						for(int ib=0;ib<xb;ib++){
							for(int jb=0;jb<yb;jb++){
								matrizresult[i][j]=matriz[i][j]-matrizB[ib][jb];
							}
						}
						}
					}
				mostrarMatrizResult();
				}		
			break;
		case(3):
			int multiplicar;
			System.out.println("4 - Multiplicar por um número REAL");	//ok
			System.out.println("5 - Multiplicar pela matriz B");
			multiplicar=op.nextInt();
			
			int ab = 0;
				if(multiplicar==4){	//ok
					System.out.println("Informe o valor no qual a matriz sera multiplicada");
					multiplicar=op.nextInt();
					System.out.println("Multiplicar a Matriz A ou B?");
					System.out.println("1 - A");
					System.out.println("2 - B");
					ab=op.nextInt();
				}
						if(ab==1){	//ok
							setMatrizResult();
							System.out.println("O valor da sua matriz e:");
								for(i=0;i<x;i++){
									for(j=0;j<y;j++){
										matrizresult[i][j]=matriz[i][j]*multiplicar;
							}
						
						}
			mostrarMatrizResult();
			}	
						if(ab==2){	//ok
							setMatrizResult();
							System.out.println("O valor da sua matriz e:");
							for(i=0;i<xb;i++){
								for(j=0;j<yb;j++){
									matrizresult[i][j]=matrizB[i][j]*multiplicar;
						}
					}
			mostrarMatrizResult();
		}		
			if(multiplicar==5 && y==xb){ // fazer calculos
					// 2x2
				if(x==2 && y==2 && yb==2 && xb==2 ){
					matrizresult= new int[x][yb];
					int a11=matriz[0][0]*matrizB[0][0]+matriz[0][1]*matrizB[1][0];
					int a12=matriz[0][0]*matrizB[0][1]+matriz[0][1]*matrizB[1][1];
					int a21=matriz[1][0]*matrizB[0][0]+matriz[1][1]*matrizB[1][0];
					int a22=matriz[1][0]*matrizB[0][1]+matriz[1][1]*matrizB[1][1];
					matrizresult[0][0]=a11;
					matrizresult[0][1]=a12;
					matrizresult[1][0]=a21;
					matrizresult[1][1]=a22;
					mostrarMatrizResult(x,yb);
				}
					//2x2 2x3
				if(x==2 && y==2 && xb==2 && yb==3){
					matrizresult=new int[x][yb];
					int a11=matriz[0][0]*matrizB[0][0]+matriz[0][1]*matrizB[1][0];
					int a12=matriz[0][0]*matrizB[0][1]+matriz[0][1]*matrizB[1][1];
					int a21=matriz[1][0]*matrizB[0][0]+matriz[1][1]*matrizB[1][0];
					int a22=matriz[1][0]*matrizB[0][1]+matriz[1][1]*matrizB[1][1];
					int a13=matriz[0][0]*matrizB[0][2]+matriz[0][1]*matrizB[1][2];
					int a23=matriz[1][0]*matrizB[0][2]+matriz[1][1]*matrizB[1][2];
					matrizresult[0][0]=a11;
					matrizresult[0][1]=a12;
					matrizresult[0][2]=a13;
					matrizresult[1][0]=a21;
					matrizresult[1][1]=a22;
					matrizresult[1][2]=a23;
					mostrarMatrizResult(x,yb);
				}
					//2x2 2x4 
				if(x==2 && y==2 && xb==2 && yb==4){
					matrizresult=new int[x][yb];
					int a11=matriz[0][0]*matrizB[0][0]+matriz[0][1]*matrizB[1][0];
					int a12=matriz[0][0]*matrizB[0][1]+matriz[0][1]*matrizB[1][1];
					int a21=matriz[1][0]*matrizB[0][0]+matriz[1][1]*matrizB[1][0];
					int a22=matriz[1][0]*matrizB[0][1]+matriz[1][1]*matrizB[1][1];
					int a13=matriz[0][0]*matrizB[0][2]+matriz[0][1]*matrizB[1][2];
					int a23=matriz[1][0]*matrizB[0][2]+matriz[1][1]*matrizB[1][2];
					int a14=matriz[0][0]*matrizB[0][3]+matriz[0][1]*matrizB[1][3];
					int a24=matriz[1][0]*matrizB[0][3]+matriz[1][1]*matrizB[1][3];
					matrizresult[0][0]=a11;
					matrizresult[0][1]=a12;
					matrizresult[0][2]=a13;
					matrizresult[0][3]=a14;
					matrizresult[1][3]=a24;
					matrizresult[1][0]=a21;
					matrizresult[1][1]=a22;
					matrizresult[1][2]=a23;
					mostrarMatrizResult(x,yb);
				}
					//1x1 //1x1
				if(x==1 && y==1 && xb==1 && yb==1){
					matrizresult=new int[x][yb];
				}
					//1x1 //1x2
				if(x==1 && y==1 && xb==1 && yb==1){
					matrizresult=new int[x][yb];
				}
					//1x1 //1x3
				if(x==1 && y==1 && xb==1 && yb==3){
					matrizresult=new int[x][yb];
				}
					//1x1 //1x4
				if(x==1 && y==1 && xb==1 && yb==4){
					matrizresult=new int[x][yb];
				}
				// teste
		
			}
			if(multiplicar==5 && y!=xb){
				System.out.println("O numero de COLUNAS de A nao e igual o numero de LINHAS de B");
			}	
			break;
		case(4): //ok
			tipoMatriz();
			break;
		case(5):
			System.out.println("Qual matriz deseja saber a Inversa?");
			System.out.println("1 - A");
			System.out.println("2 - B");
			int temp =op.nextInt();
				if(temp==1){
																		/* A ser FEITO	
				-------------------------------------------------------------------------------------------------------------------------------------------
					int result[][]=new int [x][y];
						for(i=0;i<x;i++){
							for(j=0;j<y;j++){
								for(int ib=0;ib<xb;ib++){
									for(int jb=0;jb<yb;jb++){
								
								
						}
					}
				}
			}
		}
				if(temp==2){
					int result[][]=new int [xb][yb];
						for(i=0;i<xb;i++){
							for(j=0;j<yb;j++){
								for(int ib=0;ib<x;ib++){
									for(int jb=0;jb<y;jb++){
								
								
						}
					}
				}
			}
			----------------------------------------------------------------------------------------------------------------------------------------------------*/  
		}
	}
}

	void escolhaMatriz(){//falta LEIFORMACAO
		int escMatriz;
		//System.out.println("Escolha oque deseja fazer");
		System.out.println("1 - Ja tenho os valores da matriz A e B");//ok
		System.out.println("2 - Gostaria de informa a lei de formacao para A e B");
		System.out.println("3 - Gerar uma matriz aleatoria");	//ok
		System.out.println("0 - Sair"); //ok
		escMatriz=op.nextInt();
		menu : switch(escMatriz){
		case(0): //ok
			break menu;
		case(1):{ //ok
			ordemMatrizB();
			criarMatrizB();
			operacoesMatriz();
			break;
			}
		case(2):{
			leiFormacao();
			//mostrarMatriz();
			break;
		}
		case(3):{ //ok
			criarMatrizAleatoria();
			mostrarMatriz();
			break;
		}	
	}
}
	
	void operacoes(){ // chatim
		
		System.out.println("1 - Somar");
		System.out.println("2 - Subtrair");
		System.out.println("3 - Multiplicar");
		System.out.println("4 - Dividir");
		System.out.println("5 - Elevar");
		operacoesValor=op.nextInt();
			if(operacoesValor==1){
				for(i=0;i<x;i++){
					for(j=0;j<y;j++){
					
							if(i==j){
							matriz[i][j]=i+j;
							}
					}
				}
			}
			
			if (operacoesValor==2){
				for(i=0;i<x;i++){
					for(j=0;j<y;j++){
					
							if(i==j){
								matriz[i][j]=i-j;
							}
					}
				}
		}
			if (operacoesValor==3){
				for(i=0;i<x;i++){
					for(j=0;j<y;j++){
					
							if(i==j){
								matriz[i][j]=i*j;
							}
					}
				}
		}
			if (operacoesValor==4){
				for(i=0;i<x;i++){
					for(j=0;j<y;j++){
					
							if(i==j){
								matriz[i][j]=i/j;
							}
					}
				}
		}
			if (operacoesValor==5){
				for(i=0;i<x;i++){
					for(j=0;j<y;j++){
		
							if(i==j){
								double ti = i,tj=j;
								matriz[i][j]=	(int) Math.pow(ti,tj);
							}
					}
				}
		}
			if (operacoesValor<0 || operacoesValor>5){
				System.out.print("Opcao invalida");
		}
			//}
		//}
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	void leiFormacao(){ //ok
		System.out.println("Quando i=j :");
		operacoes();
		System.out.println("Quando i>j");
		operacoes();
		System.out.println("Quando i<j");
		operacoes();
		mostrarMatriz();
	}
	
	void verificaLinhasColunas(){	//ok
		if (x==0){
			System.out.println("Número de Linhas nao podem ser 0 ");
		}
		if (y==0){
			System.out.println("Número de Colunas não podem ser 0");
		}
	}
	
	void criarMenu(){	//ok
		int option=0;
		menu : while(option==0){
		System.out.println("Qual teorema deseja utilizar?");
		System.out.println("1 - Laplace"); //ok
		System.out.println("2 - Sarrus"); //ok
		System.out.println("0 - Sair"); //ok
		option=op.nextInt();
		
			if(option==1){
				utilizarLaplace();
		}
			if(option==2){
				utilizarSarrus();
		}
			if(option==0){
				System.out.println("Programa Encerrado ....");
				break menu;
			}
			if(option <0 || option>2){
				System.out.println("Opcao INVALIDA");
				criarMenu();
			}
		}
	}
	
	void criarMatrizAleatoria(){	// ok
		ordemMatriz();
			for(i=0;i<x;i++){
				for(j=0;j<y;j++){
					matriz[i][j]= (int)(100*Math.random());
			}
		}
	}
	
	void criarMatriz(){ //ok
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				System.out.print("a"+(i+1)+""+(j+1)+":  ");
				n = op.nextInt();
				matriz[i][j] = n;
			}
		}
	}

	void criarMatrizB(){ //ok
		criarMatriz();
		int n;
		for (i = 0; i < xb; i++) {
			for (j = 0; j < yb; j++) {
				System.out.print("b"+(i+1)+""+(j+1)+":  ");
				n = op.nextInt();
				matrizB[i][j] = n;
			}
		}		
	}
	
	void mostrarMatrizResult(){ //ok
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				System.out.print(matrizresult[i][j]+"\t" );
				}
			System.out.println("");
		}
	
	}
	
	void mostrarMatrizResult(int x,int y){
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				System.out.print(matrizresult[i][j]+"\t" );
				}
			System.out.println("");
		}
	}
	
	void mostrarMatriz(){ //ok
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				System.out.print(matriz[i][j]+"\t" );
				}
			System.out.println("");
		}
	}
	
	void mostrarMatrizB(){ //ok
		for (i = 0; i < xb; i++) {
			for (j = 0; j < yb; j++) {
				System.out.print(matrizB[i][j]+"\t" );
				}
			System.out.println(""); 
		}
		
	}
	
	void verificarMatriz(){ //deprecated
		if (x==3 && y ==3){
			utilizarSarrus();
			utilizarLaplace();
		}
	}
	
	void utilizarSarrus(){ // Calculo ok 3x3
		if (x==3 && y==3){
			diagPrinc = matriz[0][0] * matriz[1][1] * matriz[2][2] + matriz[1][0] * matriz[2][1] * matriz[0][2] + matriz[2][0]* matriz[0][1] * matriz[1][2];
			diagSecond = matriz[0][2] * matriz[1][1] * matriz[2][0] + matriz[1][2] * matriz[2][1] * matriz[0][0] + matriz[2][2] * matriz[0][1] * matriz[1][0];
			sarrus = diagPrinc - (diagSecond);
			System.out.println("Utilizando SARRUS o resultado é: "+NumberFormat.getIntegerInstance().format(sarrus));
		}
		else {
			System.out.println("Sua matriz deve ser de Ordem 3 para utilizar o metodo de SARRUS! \n");
			redefinirOrdemMatriz();
		}
	}
	
	void utilizarLaplace(){ // Calculo OK 3x3 e 4x4
		if(x==y){
			double c,detA,b,result,d;
				if(x==3 && y==3){
			 // Calculo ok UTILIZANDO a PRIMEIRA COLUNA.
					detA=matriz[0][0]* Math.pow((-1),(1+1))*(matriz[1][1]*matriz[2][2]-matriz[2][1]*matriz[1][2]);
					c=matriz[1][0]* Math.pow((-1),(2+1)) * (matriz[0][1]*matriz[2][2] - matriz[0][2]*matriz[2][1]);
					b=matriz[2][0]* Math.pow((-1),(3+1))* (matriz[0][1]*matriz[1][2] - matriz[0][2]*matriz[1][1]) ;
					result= detA+c+b;
					System.out.print("Utilizando LAPLACE o resultado é: "+ NumberFormat.getIntegerInstance().format(result));
		}
				if(x==4 && y==4){
				 // Calculo TO DO UTILIZANDO a PRIMEIRA COLUNA.
						// 1 4
					diagPrinc = matriz[0][0] * matriz[1][1] * matriz[2][2] + matriz[1][0] * matriz[2][1] * matriz[0][2] + matriz[2][0]* matriz[0][1] * matriz[1][2];
					diagSecond = matriz[0][2] * matriz[1][1] * matriz[2][0] + matriz[1][2] * matriz[2][1] * matriz[0][0] + matriz[2][2] * matriz[0][1] * matriz[1][0];
					int diagPrinc1 = diagPrinc - (diagSecond);
					detA=matriz[0][3]* Math.pow((-1),(1+4))*(diagPrinc1);
		//System.out.println(detA);
						// 2 4
					diagPrinc = matriz[0][0] * matriz[2][1] * matriz[3][2] + matriz[2][0] * matriz[3][1] * matriz[0][2] + matriz[3][0]* matriz[0][1] * matriz[2][2];
					diagSecond = matriz[0][2] * matriz[2][1] * matriz[3][0] + matriz[0][0] * matriz[3][1] * matriz[2][2] + matriz[2][0] * matriz[0][1] * matriz[3][2];			
					int diagPrinc2=diagPrinc-(diagSecond);
					c=matriz[1][3]* Math.pow((-1),(2+4)) * (diagPrinc2);
				
				
	//System.out.println(c);
						//3 4
				
					diagPrinc = matriz[0][0] * matriz[1][1] * matriz[3][2] + matriz[1][0] * matriz[3][1] * matriz[0][2] + matriz[3][0]* matriz[0][1] * matriz[1][2];
					diagSecond = matriz[3][0] * matriz[1][1] * matriz[0][2] + matriz[0][0] * matriz[3][1] * matriz[3][1] + matriz[1][2] * matriz[0][1] * matriz[3][2];
					int diagPrinc3 = diagPrinc - (diagSecond);
					b=matriz[2][3]* Math.pow((-1),(3+4))* (diagPrinc3) ;
				
					// 4 4

					diagPrinc = matriz[0][0] * matriz[0][1] * matriz[0][2] + matriz[1][0] * matriz[2][1] * matriz[0][2] + matriz[2][0]* matriz[0][1] * matriz[1][2];
					diagSecond = matriz[2][0] * matriz[1][1] * matriz[0][2] + matriz[0][0] * matriz[2][1] * matriz[1][2] + matriz[1][0] * matriz[0][1] * matriz[2][2];
					int diagPrinc4 = diagPrinc - (diagSecond);
					d=matriz[3][3]* Math.pow((-1),(4+4))* (diagPrinc4) ;
					double total=detA+(c)+(b)+(d);
					System.out.print("Utilizando LAPLACE o resultado é: "+NumberFormat.getIntegerInstance().format(total));
				
			}
	} 
		if(x!=3 || x!=4 && y!=3 || y!=4){
		System.out.println("Para utilizar LAPLACE a matriz deve ser QUADRADA Ordem 3 ou 4\n");
		redefinirOrdemMatriz();
	}
		
		//Laplace qlqr matriz quadrada.
				
		}
	
	public int getX(){ //ok
		return x;		
	}	
	public int getY(){//ok
		return y;
	}
	
void setX(int x){//ok
		this.x=x;
	}
	void setY(int y){//ok
		this.y=y;
	}
	public int getXB(){//ok
		return xb;
	}
	public int getYB(){//ok
		return yb;
	}
	
	void getYB(int YB){//ok
		this.yb=YB;
	}
	void getXB(int XB){//ok
		this.xb=XB;
	}
	
	void setMatriz(){//ok
		matriz= new int[x][y];
		
		}
	void setMatrizB(){//ok
		matrizB= new int[xb][yb];
	}
	
	void setMatrizResult(){//ok
		matrizresult=new int[x][y];
	}
}

public class Matriz {

	public static void main(String args[]) {
		Matriz2 mat = new Matriz2();
		mat.principalMenu();
		}
}
