import React, { useState } from 'react';
import EmailJS from '@emailjs/browser';

const SignUpForm = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [location, setLocation] = useState('');
  const [groupOption, setGroupOption] = useState('create');
  const [groupName, setGroupName] = useState('');
  const [existingGroups, setExistingGroups] = useState([]);

  // endpoint to get groups - http://localhost:8080/groups
  // endpoint to add group - http://localhost:8080/group

  const handleSignUp = async (e) => {
    e.preventDefault();

    if (groupOption === 'create') {
      // Uses EmailJS to send an email to the group organizer
      await EmailJS.send('service_elz78fs', 'template_kmzey75', {
        to_name: 'Event Organizer',
        to_email: 'codechampion@outlook.com',
        message: `Hello! ${name} has created a group!`,
      }, 'WR04ZCXsGKETfDiFH').then(
        (response) => {
          console.log('Email sent!', response);
        },
        (error) => {
          console.error('Email could not be sent:', error);
        }
      );

      // Use the updated state to check if the group name already exists
      const groupExists = existingGroups.some((group) => group === groupName);
      if (groupExists) {
        alert('Group name already exists. Please choose a different name.');
        return;
      }
    }

    if (groupOption === 'join') {
      // Uses EmailJS to send an email to the group organizer
      await EmailJS.send('service_elz78fs', 'template_kmzey75', {
        to_name: 'Event Organizer',
        to_email: 'codechampion@outlook.com',
        message: `Hello! ${name} has joined your group!`,
      }, 'WR04ZCXsGKETfDiFH').then(
        (response) => {
          console.log('Email sent!', response);
        },
        (error) => {
          console.error('Email could not be sent:', error);
        }
      );
    }

    // Resets form fields after submission
    setName('');
    setEmail('');
    setLocation('');
    setGroupName('');
    setGroupOption('create');
  };

  return (
    <form onSubmit={handleSignUp}>
      <input
        type="text"
        placeholder="Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <input
        type="text"
        placeholder="Location"
        value={location}
        onChange={(e) => setLocation(e.target.value)}
      />
      <div>
        <label>
          <input
            type="radio"
            value="create"
            checked={groupOption === 'create'}
            onChange={() => setGroupOption('create')}
          />
          Create a new group
        </label>
        <label>
          <input
            type="radio"
            value="join"
            checked={groupOption === 'join'}
            onChange={() => setGroupOption('join')}
          />
          Join an existing group
        </label>
      </div>
      {groupOption === 'create' && (
        <input
          type="text"
          placeholder="New Group Name"
          value={groupName}
          onChange={(e) => setGroupName(e.target.value)}
        />
      )}
      {groupOption === 'join' && (
  <select
    value={groupName}
    onChange={(e) => setGroupName(e.target.value)}
  >
    {existingGroups.map((group, index) => (
      <option key={index} value={group}>
        {group}
      </option>
    ))}
  </select>
)}

      <button type="submit">Sign Up</button>
    </form>
  );
};

export default SignUpForm;
