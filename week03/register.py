#1
print('==============================')
print('ȸ������')
print('==============================')

while True:
  print('ȸ�������� �����Ͻðڽ��ϱ�?')
  print('y: ����          n: ���')
  answer=input('>> ')
  answer=answer.lower() #�ҹ��ڷ� ��ȯ
  if answer=='y':
    print('==============================')
    print('ȸ�������� ����˴ϴ�.')
    print('==============================')
    break
  elif answer=='n':
    print('==============================')
    print('ȸ�������� ��ҵ˴ϴ�.')
    print('==============================')
    exit()
  else:
    print("'y' �Ǵ� 'n'�� �Է����ּ���. ")

#2
users=[]

while True:
  user={}
  
  #���̵� �Է�
  username=input('ID: ')
  
  #��й�ȣ �Է�
  while True:
    pwd=input('��й�ȣ: ')
    pwd2=input('��й�ȣ Ȯ��: ')
    if pwd==pwd2:
      break
    else: #pwd!=pwd2
      print("��й�ȣ�� ��ġ���� �ʽ��ϴ�.")
  
  #�̸� �Է�
  name=input('�̸�')
  
  #���� �Է�
  while True:
    birth=input('�������(6�ڸ�): ')
    if len(birth)==6:
      break
    else:
      print('��������� ���� �ڸ��� �Է����ּ���.')
  
  #�̸��� �Է�
  email=input('�̸���: ')
  
  
  
  #3
  user['username']=username
  user['password']=pwd
  user['name']=name
  user['birth']=birth
  user['email']=email
  
  users.append(user)
  print(users)
  
  print('==============================')
  print(user['name'], '��, ������ ȯ���մϴ�!')
  print('==============================')
  print('ȸ�������� �߰��� �����Ͻðڽ��ϱ�?')
  print('y: ����          n: ���')
  answer=input('>> ')
  answer=answer.lower()
  
  if answer=='y':
    pass
  elif answer=='n':
    exit()
  else:
    exit()