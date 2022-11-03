% Dirac
N = 10; % number of samples
n = -N/2:N/2; % vector
d = [zeros(1,N/2) 1 zeros(1,N/2)];
figure; % display
stem(n,d);
xlabel('n');
ylabel('\delta(n)');
title('Dirac function');
axis([-N/2 N/2 0 1.1]);