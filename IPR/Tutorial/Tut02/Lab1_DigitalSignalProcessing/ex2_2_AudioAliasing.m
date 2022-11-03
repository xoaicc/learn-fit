T = 2; %parameters
f0 = 1000;
fs1 = 20000;
fs2 = 1500;
[x1, t1] = sin_NU(fs1,f0,T);
[x2, t2] = sin_NU(fs2,f0,T);
figure;
plot(t1,x1,t2,x2,'LineWidth',3.0),
axis([0, 0.005, -1.1, 1.1])
legend('High Frequency','Low Frequency')
xlabel('Time')
ylabel('Signals')
title('Audio aliasing');
%%%
soundsc(x1,fs1)
%%%
soundsc(x2,fs2)