% Sinc function
L = 50;
n = [-L:L];
Ts = 0.1;
x = zeros(1,length(n));
x(n~=0) = sin(pi*n(n~=0)*Ts)./(pi*n(n~=0)*Ts); %logic for sinc
x(n==0) = 1;
figure; % display
stem(n,x);
xlabel('n');
ylabel('sin');
title('Sinc function');