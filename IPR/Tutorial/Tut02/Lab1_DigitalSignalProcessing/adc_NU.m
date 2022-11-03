function y = adc_NU(x, R, B)
level = [0:R/(2^B):R-R/(2^B)];
temp = [-Inf,(level(2:end)-R/(2^(B+1))),Inf];
y = zeros(1,length(x));
for i = 1:length(level)
y = y + (x >= temp(i)).*(x < temp(i+1)).*level(i);
end
