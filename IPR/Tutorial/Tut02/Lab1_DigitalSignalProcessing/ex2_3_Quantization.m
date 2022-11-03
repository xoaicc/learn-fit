% ADC_NU function test
R = 10;
B = 3;
x = -5:15;
y = adc_NU(x,R,B);
t = 0:length(x)-1;
figure(11)
plot(t,x,t,y)
plot(t,x,'g-*','LineWidth',2.2)
hold on
stem(t,y,'filled','LineWidth',2.2)
hold off
title('Ramp function unipolar quantization')
xlabel('Time in sec')
ylabel('Signal magnitude in volts')
axis([-0.1,20.1,-5.1,15.1])