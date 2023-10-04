int main()
{
    int a;
    int b;
    int c;
    int d;
    d = 1;
    b = 1;
    a=b+2*(100-1);
    for(c = 1;c < 5;c = c + 1){
        while(d < 4){
            printf("a = %d\n", a);
            printf("c = %d\n", d);
            d = d + 1;
        }
        d = 1;
    }

}
