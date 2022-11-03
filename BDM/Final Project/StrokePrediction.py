# Preparing all libraries
import numpy as np
import pandas as pd
from sklearn import preprocessing
from sklearn.ensemble import RandomForestClassifier, BaggingClassifier
from sklearn.metrics import classification_report
from sklearn.model_selection import train_test_split

# Loading data from project folder
strokeData = pd.read_csv('Datasets/healthcare-dataset-stroke-data.csv')

print(strokeData.head())
print(strokeData.shape)

# Dropping some unnecessary features
strokeData = strokeData.drop(columns=['id', 'gender', 'ever_married', 'work_type', 'Residence_type'])

# Replacing all values that cannot be parsed into useful values
newStroke1 = strokeData.replace('Unknown', np.nan)
newStroke2 = newStroke1.replace('never smoked', 0)
newStroke3 = newStroke2.replace('formerly smoked', 1)
newStroke4 = newStroke3.replace('smokes', 2)

# Dropping all the rows with na values
print(newStroke4.isnull().sum())
newStroke5 = newStroke4.dropna(axis=0)

newStroke6 = newStroke5.sample(frac=1).reset_index(drop=True)

print(newStroke6.head())
print(newStroke6.shape)
print(newStroke6.dtypes)

# Splitting into X & y
X = newStroke6[['age', 'hypertension', 'heart_disease', 'avg_glucose_level', 'bmi', 'smoking_status']]
y = newStroke6['stroke']

# Scaling X with MinMaxScaler
minmaxScaler = preprocessing.MinMaxScaler()
X_tran = pd.DataFrame(minmaxScaler.fit_transform(X))

# Splitting into X & y, train & test object
X_train, X_test, y_train, y_test = train_test_split(X_tran, y, test_size=0.3, random_state=69)

bl = RandomForestClassifier(random_state=123)

model1 = BaggingClassifier(base_estimator=bl, n_estimators=10, max_samples=0.7, max_features=0.6)
model2 = BaggingClassifier(base_estimator=bl, n_estimators=10, max_samples=0.8, max_features=0.7)
model3 = BaggingClassifier(base_estimator=bl, n_estimators=10, max_samples=0.9, max_features=0.8)

# Fitting all three models on the training data
model1.fit(X_train, y_train)
model2.fit(X_train, y_train)
model3.fit(X_train, y_train)

# Predicting probabilities of ech model on the test set
pred1 = model1.predict_proba(X_test)
pred2 = model1.predict_proba(X_test)
pred3 = model1.predict_proba(X_test)

# Calculating the ensemble prediction by averaging three base model predictions
ensemblePred = (pred1+pred2+pred3)/3

# Predicting on the test set using the average model
pred = np.argmax(ensemblePred, axis=1)

# Printing the classification report
print(classification_report(y_test, pred, zero_division=1))
