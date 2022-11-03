# Preparing the Dataset to Implement Pipelines
from sklearn.model_selection import train_test_split
import pandas as pd

filename = '../Dataset/crx.data'
credData = pd.read_csv(filename, sep=",", header=None, na_values="?")
credData.head()

credData.loc[credData[15] == '+', 15] = 1
credData.loc[credData[15] == '-', 15] = 0
credData.head()

credData.isnull().sum()

newCred = credData.dropna(axis=0)

print(credData.shape)
print(newCred.shape)

X = newCred.loc[:, 0:14]
print(X.shape)
y = newCred.loc[:, 15]
y = y.astype('int')
print(y.shape)

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=123)
print(X_train.shape)
print(X_test.shape)

# Applying Pipelines for Feature Extraction to the Dataset
from sklearn.pipeline import Pipeline
from sklearn.preprocessing import StandardScaler, OneHotEncoder
from sklearn.compose import ColumnTransformer

catTransformer = Pipeline(steps=[('onehot', OneHotEncoder(handle_unknown='ignore'))])
numTransformer = Pipeline(steps=[('scaler', StandardScaler())])

numFeatures = X.select_dtypes(include=['int64', 'float64']).columns

catFeatures = X.select_dtypes(include=['object']).columns

preprocessor = ColumnTransformer(
    transformers=[('numeric', numTransformer, numFeatures), ('categoric', catTransformer, catFeatures)])

Xtran_train = pd.DataFrame(preprocessor.fit_transform(X_train))
print(Xtran_train.shape)
Xtran_train.head()

Xtran_test = pd.DataFrame(preprocessor.transform(X_test))
print(Xtran_test.shape)
print(Xtran_test.head())

# Adding Dimensionality Reduction to the Feature Extraction Pipeline
from sklearn.decomposition import PCA

estimator = Pipeline(steps=[('preprocessor', preprocessor), ('dimred', PCA(10))])

Xtran_train = pd.DataFrame(estimator.fit_transform(X_train))

print(Xtran_train.shape)
Xtran_train.head()

Xtran_test = pd.DataFrame(estimator.transform(X_test))
print(Xtran_test.shape)
Xtran_test.head()

# Modeling and Predictions Using ML Pipelines
from sklearn.decomposition import PCA
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import classification_report
from sklearn.metrics import confusion_matrix

estimator = Pipeline(
    steps=[('preprocessor', preprocessor), ('dimred', PCA(10)), ('clf', LogisticRegression(random_state=123))])

estimator.fit(X_train, y_train)
estimator.score(X_test, y_test)

pred = estimator.predict(X_test)
print(classification_report(pred, y_test))

confusionMatrix = confusion_matrix(y_test, pred)
print(confusionMatrix)

# Spot-Checking Models Using ML Pipelines
from sklearn.decomposition import PCA
from sklearn.linear_model import LogisticRegression
from sklearn.neighbors import KNeighborsClassifier
from sklearn.ensemble import RandomForestClassifier, AdaBoostClassifier

classifiers = [
    KNeighborsClassifier(5),
    RandomForestClassifier(random_state=123),
    AdaBoostClassifier(random_state=123),
    LogisticRegression(random_state=123)
]

for classifier in classifiers:
    estimator = Pipeline(steps=[('preprocessor', preprocessor), ('dimred', PCA(10)), ('classifier', classifier)])
    estimator.fit(X_train, y_train)
    print(classifier)
    print("model score: %.2f" % estimator.score(X_test, y_test))

# Grid Search and Cross-Validation with ML Pipelines
pipe = Pipeline(
    steps=[('preprocessor', preprocessor), ('dimred', PCA()), ('classifier', AdaBoostClassifier(random_state=123))])

param_grid = {'dimred__n_components': [10, 12, 15], "classifier__n_estimators": [50, 100, 200],
              "classifier__learning_rate": [0.7, 0.6, 1.0]}

from sklearn.model_selection import GridSearchCV

# Fitting the grid search
estimator = GridSearchCV(pipe, cv=10, param_grid=param_grid)
estimator.fit(X_train, y_train)

print("Best: %f using %s" % (estimator.best_score_, estimator.best_params_))

print(classification_report(pred, y_test))
