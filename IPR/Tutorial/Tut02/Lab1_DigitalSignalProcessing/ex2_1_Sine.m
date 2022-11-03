% Sine function
L = 20;
n = 0:L-1;
f0 = 100; %initial frequency
fs = 1000; %sampling frequency
x0 = 1;
x = x0*sin(2*pi*f0/fs*n); %sine function description
figure; % display
stem(n,x);
xlabel('n');
ylabel('sin');
title('Sine');
axis([-1 L -1.1 1.1]);