clc;
clear ALL;

%------------Arithmatic Coding--------------------
str='THIS IS HANU TEST';
arith=str;
len=size(str);
le=len(2);
count=[];
disp('Arithmatic Encoding Started!');
for i=1:le-1
    count(i)=1;
    for j=i+1:le
        if str(i)==str(j)
            str(j)=0;
            count(i)=count(i)+1;
        end
    end
end
if(str(le)~=0)
    count(le)=1;
end
j=1;
%------------Transmitter part--------------------
for i=1:le
    if(str(i)~=0)
        new(j)=str(i);
        p(j)=count(i)/le;
        if(j>1)
            ar(j)=ar(j-1)+p(j);
        else
            ar(j)=p(j);
        end
        disp(['Probability for ',str(i),' is: ',num2str(p(j))]);  
        j=j+1;
    end
end
larith=size(new);
l=[];u=[];
l(1)=0;
u(1)=ar(1);
for i=2:le
    for j=1:larith(2)
        if(arith(i)==new(j))
           l(i)=l(i-1)+(u(i-1)-l(i-1))*(ar(j)-p(j));
           u(i)=l(i-1)+(u(i-1)-l(i-1))*ar(j);
        end
    end
end
tag=(l(i)+u(i))/2;
disp(['The tag is: ',num2str(tag)]);

%----------------Reciever part--------------
disp('Arithmatic Decoding Started!');
rec='a';
tagr=tag;
for i=1:le
    for j=1:larith(2)
        if(tagr<ar(j) && tagr>(ar(j)-p(j)))
            rec(i)=new(j);
            nm=j;
        end
    end
    if(nm>1)
        tagr=(tagr-ar(nm-1))/p(nm);
    else
        tagr=tagr/p(nm);
    end
end

disp(['Recieved word is: ',rec]);
if(rec==arith)
    disp('Succesfully Recieved!');
else
    disp('Sorry not recieved successfully!');
end