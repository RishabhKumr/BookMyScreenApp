 @Autowired
      private UserRepository userRepo;

      @Override
      public User addUser(User user) {
            if(user!=null)
            {
                  return userRepo.saveAndFlush(user);
                  
            }
            return null;
      }

      @Override
      public boolean loginUser(String username, String password) {
            
            User user1 = userRepo.validateUser(username, password);
            System.out.println("User: "+ user1.getUsername());
            if(user1!=null)
            {
                  return true;
            }
            return false;
      }

      @Override
      public List<User> getAllUsers() {
      
            List<User> userList = userRepo.findAll();
            
            if(userList!=null & userList.size() >0)
            {
                  return userList;
            }
            else
                  return null;
      }
      