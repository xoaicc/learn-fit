function [x, t] = sin_NU(fs, f0, T) %function to generate sine signal
t = 0:1/fs:T; %the signal vector output
x = sin(2*pi*f0*t); %the time vector output
end

