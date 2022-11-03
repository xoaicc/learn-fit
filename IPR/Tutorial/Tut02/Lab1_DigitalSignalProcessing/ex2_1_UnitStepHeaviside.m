% Unit step function
N = 10; % number of samples
n = -N/2:N/2; % vector
u = [zeros(1,N/2) 1 ones(1,N/2)]; %logic to give unit
step
figure; % display
stem(n,u);
xlabel('n');
ylabel('u(n)');
title('Unit step function'); %title
axis([-N/2 N/2 0 1.1]);